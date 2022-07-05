package com.wallet.transations.factory.DayTimePeriod;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.wallet.transations.Models.TimePeriodModel;

public class Morning implements IDayTime {

    @Override
    public BigDecimal getLimit() {
        return BigDecimal.valueOf(4000.00);
    }

    @Override
    public TimePeriodModel getTimePeriod(LocalDateTime now) {

        LocalDateTime begin = now.with(LocalTime.of(6, 00));
        LocalDateTime end = now.with(LocalTime.of(17, 59, 59));

        return new TimePeriodModel(begin, end);
    }

}
