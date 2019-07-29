package com.example.moneymanagement.services;


import com.example.moneymanagement.entities.User;
import com.example.moneymanagement.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    //@Autowired
   // private BCryptPasswordEncoder pwEncoder;

    @Autowired
    public UserService(UserRepository userRepo) { //BCryptPasswordEncoder pwEncoder) {
        this.userRepo = userRepo;
        //this.pwEncoder = pwEncoder;
    }

    public User newUser(User newUser) throws Error {
        User exists = userRepo.findUserByemail(newUser.getEmail());
        if (exists != null) {
            throw new Error("An account with this email already exists");
        }
        User user = new User();
        user.setUsername(newUser.getUsername());
        user.setPassword(/*pwEncoder.encode*/newUser.getPassword());
        user.setFirstName(newUser.getFirstName());
        user.setLastName(newUser.getLastName());
        user.setEmail(newUser.getEmail());
        return userRepo.save(newUser);

    }

    public User updateUser(UUID id, User user) {
        User updatedUser = userRepo.findById(id).get();
        updatedUser.setPassword(/*pwEncoder.encode(*/user.getPassword());
        updatedUser.setEmail(user.getEmail());
        return userRepo.save(user);
    }

    public User findUserById(UUID id) {
        return userRepo.findById(id).get();

    }

    public boolean deleteUser(UUID id) {
        userRepo.deleteById(id);
        return true;
    }

    public Iterable<User> findAllUsers() {
        return userRepo.findAll();
    }

}



