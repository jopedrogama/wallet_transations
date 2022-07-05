package com.wallet.transations.Repositories;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wallet.transations.Models.PaymentModel;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentModel, UUID> {

    @Query("SELECT p FROM PaymentModel p WHERE p.wallet.id = :walletId AND p.paymentDate >= :minDate and p.paymentDate <= :maxDate")
    List<PaymentModel> findPaymentsInDateTimePeriod(
            @Param("walletId") UUID ownerId,
            @Param("minDate") LocalDateTime minimunDate,
            @Param("maxDate") LocalDateTime maximumDate);

}
