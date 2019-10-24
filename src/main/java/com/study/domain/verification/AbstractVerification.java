package com.study.domain.verification;

import com.study.domain.Payment;

public abstract class AbstractVerification {
    private AbstractVerification next;

    public void linkNext(AbstractVerification next) {
        this.next = next;
    }

    public abstract boolean check(Payment payment);

    protected boolean checkNext(Payment payment) {
        if (next == null) {
            return true;
        }
        return next.check(payment);
    }
}
