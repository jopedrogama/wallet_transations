package com.wallet.transations.factory;

import java.time.LocalDateTime;
import java.time.LocalTime;

import com.wallet.transations.factory.DayTimePeriod.IDayTime;
import com.wallet.transations.factory.DayTimePeriod.Morning;
import com.wallet.transations.factory.DayTimePeriod.Night;

public class TimeFactory {

    public static IDayTime getInstance(LocalDateTime now) {
        LocalTime morningBegin = LocalTime.of(6, 00);
        LocalTime morningEnd = LocalTime.of(17, 59);

        if ((now.toLocalTime()).compareTo(morningBegin) >= 0 &&
                (now.toLocalTime().compareTo(morningEnd) <= 0)) {
            return new Morning();
        } else {
            return new Night();
        }
    }
}
