package com.example.moneymanagement.services;


import com.example.moneymanagement.entities.Account;
import com.example.moneymanagement.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AccountService {

    private AccountRepository accountRepo;

    @Autowired
    public AccountService(AccountRepository accountRepo) {
        this.accountRepo = accountRepo;
    }

    public Account createAnAccount(Account account) {
        return accountRepo.save(account);
    }

    public Account getUserAccount(Long id) {
        return accountRepo.findById(id).get();
    }

    public Boolean deleteAnAccount(Long id) {
        accountRepo.deleteById(id);
        return true;
    }

    public Iterable<Account> getAllUserAccounts(Long id) {
        return accountRepo.getAllAccountsById(id);
    }


}
