package com.study.domain.verification;

import com.study.domain.Bank;
import com.study.domain.Payment;

public class InternationalPay extends AbstractVerification {
    private Bank bank;

    public InternationalPay(Bank bank) {
        this.bank = bank;
    }

    @Override
    public boolean check(Payment payment) {
        if (bank.isInternationalLicensed()) {
            System.out.println("There is permission to perform international payment");
            return checkNext(payment);
        }
        System.out.println("There is no permission to perform international payment");
        return false;
    }
}
