package com.example.moneymanagement.services;
import com.example.moneymanagement.entities.Account;
import com.example.moneymanagement.repositories.AccountRepository;
import com.example.moneymanagement.requestobject.AccountRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AccountService {

    private AccountRepository accountRepo;

    @Autowired
    public AccountService(AccountRepository accountRepo) {
        this.accountRepo = accountRepo;
    }

    public Account createAnAccount(AccountRequest account) {
        String accountName = account.getAccountName();
        Double balance = account.getBalance();
        Account accountEntity = new Account();

        accountEntity.setAccountName(accountName);
        account.setBalance(balance);
        return accountRepo.save(accountEntity);
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
