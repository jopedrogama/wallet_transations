package com.wallet.transations.Util;

import java.math.BigDecimal;

public class IsAllowedToPay {

    private BigDecimal limitPerPayment;
    private BigDecimal paymentAmount;

    public IsAllowedToPay(BigDecimal transationAmount) {
        this.limitPerPayment = BigDecimal.valueOf(1000);
        this.paymentAmount = transationAmount;
    }

    public boolean execute() {
        if ((this.paymentAmount).compareTo(this.limitPerPayment) >= 1) {
            return false;
        }
        return true;
    }

}
