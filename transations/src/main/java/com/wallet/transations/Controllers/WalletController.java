package com.wallet.transations.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wallet.transations.DTOs.WalletDTO;

@RestController
@RequestMapping("/wallets")
public class WalletController {

    @PostMapping
    public WalletDTO createWallet(@Valid @RequestBody WalletDTO wallet) {
        return wallet;
    }

    @GetMapping
    public List<WalletDTO> listWallets() {
        return null;
    }
}
