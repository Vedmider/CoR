package com.study.domain.verification;

import com.study.domain.Payment;

public class Payable extends AbstractVerification {
    @Override
    public boolean check(Payment payment) {
        if (payment.getAmount() > 0) {
            System.out.println("Person has money to make payment");
            return checkNext(payment);
        }
        System.out.println("Person has no money to make payment");
        return false;
    }
}
