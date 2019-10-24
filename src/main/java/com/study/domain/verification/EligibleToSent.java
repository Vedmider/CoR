package com.study.domain.verification;

import com.study.domain.Payment;

public class EligibleToSent extends AbstractVerification {

    @Override
    public boolean check(Payment payment) {
        if (payment.isAuthorized()) {
            System.out.println("Person is eligible to make payment");
            return checkNext(payment);
        }
        System.out.println("Person is not eligible to pay");
        return false;
    }
}
