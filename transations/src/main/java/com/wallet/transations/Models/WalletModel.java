package com.wallet.transations.Models;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;

@Data
public class WalletModel {

    private UUID id;
    private String ownerName;
    private LocalDateTime insertTime;
}
