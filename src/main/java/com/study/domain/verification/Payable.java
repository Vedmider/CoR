package com.study.domain.verification;

import com.study.domain.Payment;

public class Payable extends AbstractVerification {
    @Override
    public boolean check(Payment payment) {
        if (payment.getAmount() > 0){
            return checkNext(payment);
        }
        return false;
    }
}
