package com.wallet.transations.Controllers;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.wallet.transations.DTOs.PaymentDTO;
import com.wallet.transations.DTOs.Mappers.PaymentMapper;
import com.wallet.transations.Models.PaymentModel;
import com.wallet.transations.Services.PaymentService;

@RestController
@RequestMapping("/wallets")
public class PaymentController {

    @Autowired
    private PaymentMapper paymentMapper;

    @Autowired
    private PaymentService paymentService;

    @PostMapping("{walletId}/payments")
    @ResponseStatus(code = HttpStatus.OK)
    public void makePayment(@PathVariable UUID walletId, @Valid @RequestBody PaymentDTO paymentDTO) {
        PaymentModel paymentModel = paymentMapper.toModel(paymentDTO);
        PaymentModel payment = paymentService.makePayment(paymentModel, walletId);
    }
}
