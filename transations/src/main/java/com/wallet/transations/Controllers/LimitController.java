package com.wallet.transations.Controllers;

import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wallet.transations.DTOs.LimitDTO;

@RestController
@RequestMapping("/wallets")
public class LimitController {

    @GetMapping("/{walletId}/limits")
    public LimitDTO getLimit(@PathVariable Long walletId) {
        return new LimitDTO();
    }
}
