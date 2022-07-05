package com.wallet.transations.Util;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IsAllowedToPayTest {

    @Test
    public void sucess_PaymentEquals1000() {
        int value = 1000;
        IsAllowedToPay isAllowed = new IsAllowedToPay(BigDecimal.valueOf(value));
        Assertions.assertTrue(isAllowed.execute());
    }

    @Test
    public void sucess_PaymentLessThan1000() {
        int value = 900;
        IsAllowedToPay isAllowed = new IsAllowedToPay(BigDecimal.valueOf(value));
        Assertions.assertTrue(isAllowed.execute());
    }

    @Test
    public void sucess_PaymentOver1000() {
        int value = 1001;
        IsAllowedToPay isAllowed = new IsAllowedToPay(BigDecimal.valueOf(value));
        Assertions.assertFalse(isAllowed.execute());
    }

    @Test
    public void sucess_PaymentOver1000Double() {
        double value = 1000.10;
        IsAllowedToPay isAllowed = new IsAllowedToPay(BigDecimal.valueOf(value));
        Assertions.assertFalse(isAllowed.execute());
    }
}
