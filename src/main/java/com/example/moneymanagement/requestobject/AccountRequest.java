package com.example.moneymanagement.requestobject;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor


public class AccountRequest  {
    private UUID userId;
    private String accountName;
    private Double balance = 0.0;

}
