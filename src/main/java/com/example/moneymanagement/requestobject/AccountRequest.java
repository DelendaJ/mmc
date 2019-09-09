package com.example.moneymanagement.requestobject;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@NoArgsConstructor
@AllArgsConstructor


public class AccountRequest  {
    private Long accountId;
    private String accountName;
    private BigDecimal balance;

}
