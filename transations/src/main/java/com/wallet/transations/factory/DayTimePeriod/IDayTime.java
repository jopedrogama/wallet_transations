package com.wallet.transations.factory.DayTimePeriod;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.wallet.transations.Models.TimePeriodModel;

public interface IDayTime {

    public BigDecimal getLimit();

    public TimePeriodModel getTimePeriod(LocalDateTime now);
}
