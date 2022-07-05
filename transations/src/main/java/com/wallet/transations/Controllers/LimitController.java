package com.wallet.transations.Controllers;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wallet.transations.DTOs.LimitDTO;
import com.wallet.transations.Services.LimitService;

@RestController
@RequestMapping("/wallets")
public class LimitController {

    @Autowired
    private LimitService limitService;

    @GetMapping("/{walletId}/limits")
    public LimitDTO getLimit(@PathVariable UUID walletId) {
        BigDecimal value = limitService.getLimitForWallet(walletId);
        return new LimitDTO(value);
    }
}
