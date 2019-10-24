package com.study.domain.verification;

import com.study.domain.Payment;

public class EligibleToSent extends AbstractVerification {

    @Override
    public boolean check(Payment payment) {
        if (payment.isAuthorized()) {
            return checkNext(payment);
        }
        return false;
    }
}
