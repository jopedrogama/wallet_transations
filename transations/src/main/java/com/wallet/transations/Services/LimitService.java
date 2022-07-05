package com.wallet.transations.Services;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wallet.transations.Models.PaymentModel;
import com.wallet.transations.Models.TimePeriodModel;
import com.wallet.transations.Models.WalletModel;
import com.wallet.transations.Repositories.PaymentRepository;
import com.wallet.transations.factory.TimeFactory;
import com.wallet.transations.factory.DayTimePeriod.IDayTime;

@Service
public class LimitService {

        @Autowired
        private PaymentRepository paymentRepository;

        @Autowired
        private WalletService walletService;

        public BigDecimal getLimitForWallet(UUID walletId) {

                walletService.findWalletById(walletId);

                LocalDateTime currentTime = LocalDateTime.now();

                IDayTime dayTime = TimeFactory.getInstance(currentTime);
                TimePeriodModel inverval = dayTime.getTimePeriod(currentTime);

                List<PaymentModel> paymentsInThisTime = paymentRepository
                                .findPaymentsInDateTimePeriod(walletId,
                                                inverval.getBegin(),
                                                inverval.getEnd());

                BigDecimal totalAmount = paymentsInThisTime
                                .stream().map(PaymentModel::getAmount)
                                .reduce(BigDecimal.ZERO, BigDecimal::add);

                return (dayTime.getLimit()).subtract(totalAmount);

        }

        public BigDecimal getLimitForWallet_WalletExists(WalletModel wallet) {
                LocalDateTime currentTime = LocalDateTime.now();

                IDayTime dayTime = TimeFactory.getInstance(currentTime);
                TimePeriodModel inverval = dayTime.getTimePeriod(currentTime);

                List<PaymentModel> paymentsInThisTime = paymentRepository
                                .findPaymentsInDateTimePeriod(wallet.getId(),
                                                inverval.getBegin(),
                                                inverval.getEnd());

                BigDecimal totalAmount = paymentsInThisTime
                                .stream().map(PaymentModel::getAmount)
                                .reduce(BigDecimal.ZERO, BigDecimal::add);

                return (dayTime.getLimit()).subtract(totalAmount);
        }

}
