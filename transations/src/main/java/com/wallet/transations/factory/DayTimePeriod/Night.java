package com.wallet.transations.factory.DayTimePeriod;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.wallet.transations.Models.TimePeriodModel;

public class Night implements IDayTime {

    @Override
    public BigDecimal getLimit() {
        return BigDecimal.valueOf(1000.00);
    }

    @Override
    public TimePeriodModel getTimePeriod(LocalDateTime now) {
        LocalTime late = LocalTime.of(12, 00);
        if ((now.toLocalTime()).compareTo(late) >= 0) {
            LocalDateTime begin = now.with(LocalTime.of(18, 00));
            LocalDateTime end = (now.plusDays(1)).with(LocalTime.of(5, 59, 59));

            return new TimePeriodModel(begin, end);
        } else {

            LocalDateTime begin = (now.minusDays(1)).with(LocalTime.of(18, 00));
            LocalDateTime end = now.with(LocalTime.of(5, 59, 59));

            return new TimePeriodModel(begin, end);
        }
    }

}
