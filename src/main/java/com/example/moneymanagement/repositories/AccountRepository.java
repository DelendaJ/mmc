package com.example.moneymanagement.repositories;


import com.example.moneymanagement.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Iterable<Account> getAllAccountsById (Long id);
    Optional<Account> findAccountById (Long id);
}
