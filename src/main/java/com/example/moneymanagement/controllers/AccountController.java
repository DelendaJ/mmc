package com.example.moneymanagement.controllers;

import com.example.moneymanagement.entities.Account;
import com.example.moneymanagement.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AccountController {

    @Autowired
    private AccountService accountService;

    public AccountController(AccountService accService) {
        this.accountService = accService;
    }

    @GetMapping("/accounts")
    public ResponseEntity<Iterable<Account>> getAllUserAccounts(Long id) {
        return new ResponseEntity<>(accountService.getAllUserAccounts(id), HttpStatus.OK);
    }

    @GetMapping("/accounts/{id}")
    public ResponseEntity<Account> getAccount (@PathVariable Long id) {
        return new ResponseEntity<>(accountService.getUserAccount(id), HttpStatus.OK);
    }

    @PostMapping("/account")
    public ResponseEntity<Account> newAccount(@RequestBody Account account) {
        return new ResponseEntity<>(accountService.createAnAccount(account), HttpStatus.CREATED);
    }

    @DeleteMapping("/accounts/{id}")
    public ResponseEntity<Boolean> deleteAnAccount(@PathVariable Long id) {
        return new ResponseEntity<>(accountService.deleteAnAccount(id), HttpStatus.OK);
    }


}


