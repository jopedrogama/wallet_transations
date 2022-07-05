package com.wallet.Factory.DayTimePeriod;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.wallet.transations.Models.TimePeriodModel;
import com.wallet.transations.factory.DayTimePeriod.IDayTime;
import com.wallet.transations.factory.DayTimePeriod.Morning;

public class MorningTest {

    @Test
    public void pegarHorario() {
        IDayTime dayTime = new Morning();
        LocalDateTime time = LocalDateTime.of(LocalDate.of(2022, 02, 14), LocalTime.of(10, 00));
        TimePeriodModel timePeriod = dayTime.getTimePeriod(time);

        Timestamp begin = Timestamp.valueOf("2022-02-14 06:00:00");
        Timestamp end = Timestamp.valueOf("2022-02-14 17:59:59");
        Timestamp comparedBegin = Timestamp.valueOf(timePeriod.getBegin());
        Timestamp comparedEnd = Timestamp.valueOf(timePeriod.getEnd());
        Assertions.assertEquals(begin, comparedBegin);
        Assertions.assertEquals(end, comparedEnd);

    }
}
