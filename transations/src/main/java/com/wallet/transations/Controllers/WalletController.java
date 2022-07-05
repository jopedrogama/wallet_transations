package com.wallet.transations.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wallet.transations.DTOs.WalletDTO;
import com.wallet.transations.DTOs.Mappers.WalletMapper;
import com.wallet.transations.Models.WalletModel;
import com.wallet.transations.Services.WalletService;

@RestController
@RequestMapping("/wallets")
public class WalletController {

    @Autowired
    private WalletService walletService;

    @Autowired
    private WalletMapper walletMapper;

    @PostMapping
    public WalletDTO createWallet(@Valid @RequestBody WalletDTO walletDTO) {
        WalletModel walletModel = walletMapper.toModel(walletDTO);
        WalletModel savedWallet = walletService.createWallet(walletModel);
        WalletDTO walletResponse = walletMapper.toDTO(savedWallet);
        return walletResponse;
    }

    @GetMapping
    public List<WalletDTO> listWallets() {
        List<WalletModel> listOfWallets = walletService.getWallets();
        return walletMapper.toDTOList(listOfWallets);
    }
}
