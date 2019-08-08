package com.example.moneymanagement.services;
import com.example.moneymanagement.entities.User;
import com.example.moneymanagement.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {


    private UserRepository userRepo;


    @Autowired
    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;

    }


    public User newUser(User newUser) {
        Optional<User> exists = Optional.ofNullable(userRepo.findUserByemail(newUser.getEmail()));
        if (exists.isPresent())
            throw new Error("An account with this email already exists");
        User user = new User();
        user.setUsername(newUser.getUsername());
        user.setPassword(newUser.getPassword());
        user.setFirstName(newUser.getFirstName());
        user.setLastName(newUser.getLastName());
        user.setEmail(newUser.getEmail());
        return userRepo.save(newUser);

    }

    public User updateUser(UUID id, User user) {
        User updatedUser = userRepo.findById(id).get();
        updatedUser.setPassword(user.getPassword());
        updatedUser.setEmail(user.getEmail());
        return userRepo.save(user);
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


