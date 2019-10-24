package com.study.domain.verification;

import com.study.domain.Payment;

public class BankTax extends AbstractVerification{
    @Override
    public boolean check(Payment payment) {
        payment.setAmount((int) (payment.getAmount() * 0.9));
        System.out.println("Bank has got his tax amount of money");
        return checkNext(payment);
    }
}
