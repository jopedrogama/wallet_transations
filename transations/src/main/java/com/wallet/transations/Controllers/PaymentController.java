package com.wallet.transations.Controllers;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.wallet.transations.DTOs.PaymentDTO;

@RestController
@RequestMapping("/wallets")
public class PaymentController {

    @PostMapping("{walletId}/payments")
    @ResponseStatus(code = HttpStatus.OK)
    public PaymentDTO makePayment(@PathVariable Long walletId, @Valid @RequestBody PaymentDTO transationDTO) {
        return transationDTO;
    }
}
