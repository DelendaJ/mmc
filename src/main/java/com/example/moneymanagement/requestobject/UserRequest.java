package com.example.moneymanagement.requestobject;

import com.example.moneymanagement.entities.Account;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserRequest {

    private UUID userId;
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private Set<Account> accounts;


}
