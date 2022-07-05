package com.wallet.transations.Services;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wallet.transations.Models.PaymentModel;
import com.wallet.transations.Models.WalletModel;
import com.wallet.transations.Repositories.PaymentRepository;
import com.wallet.transations.Util.IsAllowedToPay;

@Service
public class PaymentService {

    @Autowired
    private LimitService limitService;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private WalletService walletService;

    public PaymentModel makePayment(PaymentModel paymentModel, UUID walletId) {

        IsAllowedToPay limit = new IsAllowedToPay(paymentModel.getAmount());
        boolean canTransfer = limit.execute();

        if (!canTransfer) {
            throw new RuntimeException("This amount isn't allowed. Maximum value of US$1000.00");
        }

        WalletModel queriedWallet = walletService.findWalletById(walletId);
        BigDecimal creditForTheDay = limitService.getLimitForWallet_WalletExists(queriedWallet);

        if (creditForTheDay.compareTo(paymentModel.getAmount()) < 0) {
            throw new RuntimeException("It's not possible to make payment. Amount is highet than Limit");
        }

        paymentModel.setPaymentDate(LocalDateTime.now());

        paymentModel.setWallet(queriedWallet);
        // BigDecimal limit = limitService.getLimitForWallet(paymentModel.getId());

        return paymentRepository.save(paymentModel);
    }

}
