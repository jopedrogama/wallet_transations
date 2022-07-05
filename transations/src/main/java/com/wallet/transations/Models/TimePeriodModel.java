package com.wallet.transations.Models;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TimePeriodModel {

    private LocalDateTime begin;
    private LocalDateTime end;

}
