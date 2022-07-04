package com.wallet.transations.Repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wallet.transations.Models.PaymentModel;

public interface PaymentRepository extends JpaRepository<PaymentModel, UUID> {

    List<PaymentModel> findByWalletId(UUID ownerId);
}
