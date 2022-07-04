package com.wallet.transations.Repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wallet.transations.Models.WalletModel;

public interface WalletRepository extends JpaRepository<WalletModel, UUID> {

}
