package com.study.domain;

import com.study.domain.verification.AbstractVerification;

import java.util.List;

public class Bank {
    private AbstractVerification internationalVerification;
    private AbstractVerification domesticVerification;
    private AbstractVerification benefitVerification;
    private AbstractVerification internalVerification;
    private List<String> users;
    private boolean isInternationalLicensed = true;

    public void setBenefitVerification(AbstractVerification benefitVerification) {
        this.benefitVerification = benefitVerification;
    }

    public void setDomesticVerification(AbstractVerification domesticVerification) {
        this.domesticVerification = domesticVerification;
    }

    public void setInternationalVerification(AbstractVerification internationalVerification) {
        this.internationalVerification = internationalVerification;
    }

    public void setInternalVerification(AbstractVerification internalVerification) {
        this.internalVerification = internalVerification;
    }

    public void setUsers(List<String> users) {
        this.users = users;
    }

    public List<String> getUsers() {
        return users;
    }

    public void setInternationalLicensed(boolean internationalLicensed) {
        isInternationalLicensed = internationalLicensed;
    }

    public boolean isInternationalLicensed() {
        return isInternationalLicensed;
    }

    public boolean makeInternationalPayment(Payment payment) {
        if (internationalVerification.check(payment)) {
            return true;
        }
        return false;
    }

    public boolean makeDomesticPayment(Payment payment) {
        if (domesticVerification.check(payment)) {
            return true;
        }
        return false;
    }

    public boolean makeBenefitPayment(Payment payment) {
        if (benefitVerification.check(payment)) {
            return true;
        }
        return false;
    }

    public boolean makeInternalBankPayment(Payment payment) {
        if (internalVerification.check(payment)) {
            return true;
        }
        return false;
    }
}
