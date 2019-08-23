package com.example.moneymanagement.services;

import com.example.moneymanagement.entities.Account;
import com.example.moneymanagement.entities.User;
import com.example.moneymanagement.repositories.UserRepository;
import com.example.moneymanagement.requestobject.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public class UserService {


    private UserRepository userRepo;


    @Autowired
    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;

    }


    public User newUser(UserRequest user) {
        Optional<User> exists = Optional.ofNullable(userRepo.findUserByemail(user.getEmail()));
        if (exists.isPresent())
            throw new Error("An account with this email already exists");
        User newUser = new User();

        String username = user.getUsername();
        String password = user.getPassword();
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        String email = user.getEmail();
        Set<Account> account = user.getAccounts();

        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        newUser.setEmail(email);
        newUser.setAccounts(account);
        return userRepo.save(newUser);

    }

    public User updateUser(UUID id, UserRequest user) {
        User currentUser = userRepo.findById(id).get();
        String password = user.getPassword();
        String email = user.getEmail();

        currentUser.setPassword(password);
        currentUser.setEmail(email);
        return userRepo.save(currentUser);
    }


    public Optional<User> findUserById(UUID id) {
        return userRepo.findById(id);
    }


    public boolean deleteUser(UUID id) {
        try {
            userRepo.deleteById(id);
        } catch (Exception e) {
            System.out.println("User not found");
        }
        return true;
    }

    public Iterable<User> findAllUsers() {
        return userRepo.findAll();
    }

}


