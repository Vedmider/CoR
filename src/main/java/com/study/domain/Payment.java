package com.study.domain;

public class Payment {
    private int amount;
    private String namePersonWhoReceive;
    private String namePersonWhoSend;
    private boolean authorized = true;

    public Payment(int amount, String namePersonWhoSend, String namePersonWhoReceive) {
        this.amount = amount;
        this.namePersonWhoSend = namePersonWhoSend;
        this.namePersonWhoReceive = namePersonWhoReceive;
    }

    public int getAmount() {
        return amount;
    }

    public String getNamePersonWhoReceive() {
        return namePersonWhoReceive;
    }

    public String getNamePersonWhoSend() {
        return namePersonWhoSend;
    }

    public boolean isAuthorized(){
        return authorized;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
