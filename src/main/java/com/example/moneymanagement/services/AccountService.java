package com.example.moneymanagement.services;

import com.example.moneymanagement.entities.Account;
import com.example.moneymanagement.repositories.AccountRepository;
import com.example.moneymanagement.requestobject.AccountRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;


@Service
public class AccountService {

    private AccountRepository accountRepo;

    @Autowired
    public AccountService(AccountRepository accountRepo) {
        this.accountRepo = accountRepo;
    }

    public Account createAnAccount(AccountRequest account) {
        String accountName = account.getAccountName();
        BigDecimal balance = account.getBalance();
        Account accountEntity = new Account();

        accountEntity.setAccountName(accountName);
        account.setBalance(balance);
        return accountRepo.save(accountEntity);
    }

    public Account getUserAccount(Long accountId) {
        return accountRepo.findById(accountId).get();
    }

    public Boolean deleteAnAccount(Long accountId) {
        try {
            accountRepo.deleteById(accountId);
        } catch (Exception e) {
            System.out.println("Account not found");
        }
        return true;
    }

    public Iterable<Account> getAllUserAccounts(Long id) {
        return accountRepo.getAllAccountsById(id);
    }

    public Account withdraw(BigDecimal amount, Account account) {
        Optional<Optional<Account>> currentAccount = Optional.ofNullable(accountRepo.findAccountById(account.getAccId()));
        if (currentAccount.isPresent()) {
            validate(amount);
            if (account.getBalance().subtract(amount).compareTo(BigDecimal.ZERO) >= 0) {
                account.setBalance(account.getBalance().subtract(amount));
            }
        }
        return accountRepo.save(account);

    }

    public Account deposit(Account account, BigDecimal amount) {
        Optional<Optional<Account>> currentAccount = Optional.ofNullable(accountRepo.findAccountById(account.getAccId()));
        if (currentAccount.isPresent()) {
            validate(amount);
            account.setBalance(account.getBalance().add(amount));
        }

        return accountRepo.save(account);
    }


    private static void validate(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) < 0)
            throw new Error("Please enter a valid amount.");
    }

}



