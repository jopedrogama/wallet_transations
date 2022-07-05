package com.wallet.Factory;

import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.wallet.transations.factory.TimeFactory;
import com.wallet.transations.factory.DayTimePeriod.IDayTime;
import com.wallet.transations.factory.DayTimePeriod.Morning;
import com.wallet.transations.factory.DayTimePeriod.Night;

public class TimeFactoryTest {

    @Test
    public void ehNoite_Cedo() {
        LocalDateTime currentTime = LocalDateTime.now().with(LocalTime.of(3, 59));
        IDayTime instancia = TimeFactory.getInstance(currentTime);
        Assertions.assertTrue(instancia instanceof Night);
    }

    @Test
    public void ehNoite_Tarde() {
        LocalDateTime currentTime = LocalDateTime.now().with(LocalTime.of(23, 00));
        IDayTime instancia = TimeFactory.getInstance(currentTime);
        Assertions.assertTrue(instancia instanceof Night);
    }

    @Test
    public void ehNoite_TardeTransicao() {
        LocalDateTime currentTime = LocalDateTime.now().with(LocalTime.of(18, 00));
        IDayTime instancia = TimeFactory.getInstance(currentTime);
        Assertions.assertTrue(instancia instanceof Night);
    }

    @Test
    public void ehNoite_CedoTransicao() {
        LocalDateTime currentTime = LocalDateTime.now().with(LocalTime.of(5, 59));
        IDayTime instancia = TimeFactory.getInstance(currentTime);
        Assertions.assertTrue(instancia instanceof Night);
    }

    @Test
    public void ehDia_CedoTransicao() {
        LocalDateTime currentTime = LocalDateTime.now().with(LocalTime.of(6, 00));
        IDayTime instancia = TimeFactory.getInstance(currentTime);
        Assertions.assertTrue(instancia instanceof Morning);
    }

    @Test
    public void ehDia_Cedo() {
        LocalDateTime currentTime = LocalDateTime.now().with(LocalTime.of(10, 00));
        IDayTime instancia = TimeFactory.getInstance(currentTime);
        Assertions.assertTrue(instancia instanceof Morning);
    }

    @Test
    public void ehDia_Tarde() {
        LocalDateTime currentTime = LocalDateTime.now().with(LocalTime.of(16, 30));
        IDayTime instancia = TimeFactory.getInstance(currentTime);
        Assertions.assertTrue(instancia instanceof Morning);
    }

    @Test
    public void ehDia_TardeTransicao() {
        LocalDateTime currentTime = LocalDateTime.now().with(LocalTime.of(17, 59));
        IDayTime instancia = TimeFactory.getInstance(currentTime);
        Assertions.assertTrue(instancia instanceof Morning);
    }
}
