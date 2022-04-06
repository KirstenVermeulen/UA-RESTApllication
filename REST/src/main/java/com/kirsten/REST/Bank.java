package com.kirsten.REST;

import java.util.HashMap;

public class Bank {

    /* FIELDS */

    private HashMap<String, BankAccount> bankAccounts;
    private int idGenerator;

    /* CONSTRUCTORS */

    public Bank() {
        this.bankAccounts = new HashMap<String, BankAccount>();
        this.idGenerator = 0;
    }

    /* METHODS */

    public String addBankAccount(BankAccount bankAccount) {
        String id = Integer.toString(this.idGenerator);
        this.bankAccounts.put(id, bankAccount);
        this.idGenerator++;
        return id;
    }

    public BankAccount getBankAccount(String id) {
        if (bankAccounts.containsKey(id)) {
            return this.bankAccounts.get(id);
        } else {
            return null;
        }
    }
}
