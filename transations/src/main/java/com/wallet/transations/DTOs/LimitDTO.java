package com.wallet.transations.DTOs;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LimitDTO {

    private BigDecimal value;
}
