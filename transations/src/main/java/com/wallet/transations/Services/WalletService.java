package com.wallet.transations.Services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wallet.transations.Models.WalletModel;
import com.wallet.transations.Repositories.WalletRepository;

@Service
public class WalletService {

    @Autowired
    private WalletRepository walletRepository;

    public WalletModel createWallet(WalletModel walletModel) {
        walletModel.setInsertTime(LocalDateTime.now());
        return walletRepository.save(walletModel);
    }

    public List<WalletModel> getWallets() {
        return walletRepository.findAll();
    }

    public WalletModel findWalletById(UUID walletId) {
        Optional<WalletModel> queriedWallet = walletRepository.findById(walletId);

        if (!queriedWallet.isPresent()) {
            throw new RuntimeException("Wallet ID is invalid!");
        }

        return queriedWallet.get();
    }
}
