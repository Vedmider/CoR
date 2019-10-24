package com.study.presentation;

import com.study.domain.Bank;
import com.study.domain.Payment;
import com.study.domain.verification.*;

import java.util.Arrays;
import java.util.Scanner;

public class ConsolePresentation {
    private static Scanner scanner = new Scanner(System.in);
    private static Bank bank;

    public static void main(String[] args) {
        System.out.println("This is a payment program");
        Payment payment = initiatePrepareData();

        bank.makeBenefitPayment(payment);
        bank.makeDomesticPayment(payment);
        bank.makeInternalBankPayment(payment);
        bank.makeInternationalPayment(payment);
    }

    private static Payment initiatePrepareData() {
        bank = new Bank();
        System.out.println("Enter name of person who send money.\n" +
                " Enter Bill please, because he is a client of our bank)");
        String namePersonWhoSendsMoney = scanner.nextLine();
        System.out.println("Enter name of person who receive money");
        String namePersonWhoReceivesMoney = scanner.nextLine();

        Payment payment = new Payment(200, namePersonWhoSendsMoney, namePersonWhoReceivesMoney);

        AbstractVerification benefitVerification = new SenderBankClient(bank);
        benefitVerification.linkNext(new Payable())
                .linkNext(new EligibleToSent());

        AbstractVerification domesticVerification = new SenderBankClient(bank);
        domesticVerification.linkNext(new Payable())
                .linkNext(new EligibleToSent())
                .linkNext(new BankTax());

        AbstractVerification internalVerification = new SenderBankClient(bank);
        internalVerification.linkNext(new Payable());

        AbstractVerification internationalVerification = new SenderBankClient(bank)
                .linkNext(new BankTax())
                .linkNext(new EligibleToSent())
                .linkNext(new Payable())
                .linkNext(new InternationalPay(bank));


        bank.setUsers(Arrays.asList("Bill", "James", "Tom", "Arnold"));
        bank.setBenefitVerification(benefitVerification);
        bank.setDomesticVerification(domesticVerification);
        bank.setInternalVerification(internalVerification);
        bank.setInternationalVerification(internationalVerification);
        return payment;
    }
}
