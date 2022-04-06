package com.kirsten.REST;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class BankController {

    private Bank bank = new Bank();

    @PostMapping("/bankaccount")
    public String newBankAccount() {
        return bank.addBankAccount(new BankAccount(0.00));
    }

    @GetMapping("/bankaccount/{id}/balance")
    public String getBalance(@PathVariable("id") String id) {
        BankAccount bankAccount = bank.getBankAccount(id);

        if (bankAccount == null) {
            return String.format("There is no bankaccount with the following account number: %s.\nYou might have the wrong number or need to create a new bankaccount.", id);
        } else {
            return String.format("Your current balance is €%.2f.", bankAccount.getBalance());
        }
    }

    @PutMapping("/bankaccount/{id}/deposit")
    public ResponseEntity<String> withdrawMoney(@PathVariable("id") String id, @RequestBody BankAccount body){
        BankAccount bankAccount = bank.getBankAccount(id);
        bankAccount.setBalance(bankAccount.getBalance() + body.getBalance());
        return new ResponseEntity<>(String.format("Your current balance is €%.2f.", bankAccount.getBalance()), HttpStatus.OK);
    }

    @PutMapping("/bankaccount/{id}/withdraw")
    public ResponseEntity<String> depositMoney(@PathVariable("id") String id, @RequestBody BankAccount body){
        BankAccount bankAccount = bank.getBankAccount(id);
        bankAccount.setBalance(bankAccount.getBalance() - body.getBalance());
        return new ResponseEntity<>(String.format("Your current balance is €%.2f.", bankAccount.getBalance()), HttpStatus.OK);
    }
}