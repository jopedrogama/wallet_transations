package com.wallet.transations.Models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;

@Data
public class PaymentModel {

    private UUID id;
    private UUID walletId;
    private BigDecimal amount;
    private LocalDateTime date;
}
