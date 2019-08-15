package com.example.moneymanagement.requestobject;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;


import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
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


}
