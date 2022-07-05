package com.wallet.transations.DTOs.Mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wallet.transations.DTOs.WalletDTO;
import com.wallet.transations.Models.WalletModel;

@Component
public class WalletMapper {

    @Autowired
    private ModelMapper modelMapper;

    public WalletModel toModel(WalletDTO walletDTO) {
        return modelMapper.map(walletDTO, WalletModel.class);
    }

    public WalletDTO toDTO(WalletModel walletModel) {
        return modelMapper.map(walletModel, WalletDTO.class);
    }

    public List<WalletDTO> toDTOList(List<WalletModel> walletModelList) {
        return walletModelList.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
