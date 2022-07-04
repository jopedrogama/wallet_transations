package com.wallet.transations.DTOs;

import java.util.UUID;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class WalletDTO {

    private UUID id;

    @NotBlank
    private String ownerName;
}
