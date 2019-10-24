package com.study.domain.verification;

import com.study.domain.Bank;
import com.study.domain.Payment;

public class SenderBankClient extends AbstractVerification {
    private Bank bank;

    public SenderBankClient(Bank bank) {
        this.bank = bank;
    }

    @Override
    public boolean check(Payment payment) {
        if (bank.getUsers()
                .contains(
                        payment.getNamePersonWhoSend())) {
            System.out.println("Person is a client of bank");
            return checkNext(payment);
        }
        System.out.println("Person is not bank client");
        return false;
    }
}
