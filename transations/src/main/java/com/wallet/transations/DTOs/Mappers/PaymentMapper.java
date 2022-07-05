package com.wallet.transations.DTOs.Mappers;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wallet.transations.DTOs.PaymentDTO;
import com.wallet.transations.Models.PaymentModel;

@Component
public class PaymentMapper {

    @Autowired
    private ModelMapper modelMapper;

    public PaymentModel toModel(@Valid PaymentDTO paymentDTO) {
        return modelMapper.map(paymentDTO, PaymentModel.class);
    }

}
