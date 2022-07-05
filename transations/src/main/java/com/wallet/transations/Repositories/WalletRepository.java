package com.wallet.transations.Repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wallet.transations.Models.WalletModel;

@Repository
public interface WalletRepository extends JpaRepository<WalletModel, UUID> {

}
