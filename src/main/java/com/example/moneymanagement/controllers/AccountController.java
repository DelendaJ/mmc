package com.example.moneymanagement.controllers;

import com.example.moneymanagement.entities.Account;
import com.example.moneymanagement.requestobject.AccountRequest;
import com.example.moneymanagement.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/user")
public class AccountController {

    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accService) {
        this.accountService = accService;
    }

    @GetMapping("/accounts")
    public ResponseEntity<Iterable<Account>> getAllUserAccounts(Long id) {
        return new ResponseEntity<>(accountService.getAllUserAccounts(id), HttpStatus.OK);
    }

    @GetMapping("/account/{id}")
    public ResponseEntity<Account> getAccount (@PathVariable Long id) {
        return new ResponseEntity<>(accountService.getUserAccount(id), HttpStatus.OK);
    }

    @PostMapping("/account")
    public ResponseEntity<Account> newAccount(@RequestBody AccountRequest account) {
        return new ResponseEntity<>(accountService.createAnAccount(account), HttpStatus.CREATED);
    }

    @PutMapping("{id}/account/{accountId}/withdraw/")
    public ResponseEntity<Account> withdraw(@PathVariable Long accountId, @PathVariable Double amount) {
        return new ResponseEntity<>(accountService.withdraw(accountId, amount), HttpStatus.OK);
    }

    @PutMapping("{id}/account/{accountId}/deposit/")
    public ResponseEntity<Account> deposit(@PathVariable Long accountId, @PathVariable Double amount) {
        return new ResponseEntity<>(accountService.deposit(accountId, amount), HttpStatus.OK);
    }

    @DeleteMapping("{id}/account/{accountId}")
    public ResponseEntity<Boolean> deleteAnAccount(@PathVariable Long accountId) {
        return new ResponseEntity<>(accountService.deleteAnAccount(accountId), HttpStatus.OK);
    }

}


