package com.kirsten.REST;

public class BankAccount {

    /* FIELDS */

    private double balance;

    /* CONSTRUCTORS */

    public BankAccount() {
    }

    public BankAccount(double balance) {
        setBalance(balance);
    }

    /* GETTERS AND SETTERS */

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    /* METHODS */


}
