package com.wallet.transations.DTOs;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class PaymentDTO {

    @NotNull
    private BigDecimal amount;

    @Future
    @NotNull
    private LocalDateTime date;
}
