package com.example.moneymanagement.services;


import com.example.moneymanagement.entities.User;
import com.example.moneymanagement.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {


    private UserRepository userRepo;
    private PasswordEncoder encoder = new BCryptPasswordEncoder();

    //@Autowired
    // private BCryptPasswordEncoder pwEncoder;

    @Autowired
    public UserService(UserRepository userRepo) { //PasswordEncoder encoder) { //BCryptPasswordEncoder pwEncoder) {
        this.userRepo = userRepo;
        //  this.encoder = encoder;

        //this.pwEncoder = pwEncoder;
    }


    public User newUser(User newUser) {
       Optional<User> exists = Optional.ofNullable(userRepo.findUserByemail(newUser.getEmail()));
        if (exists.isPresent())
            throw new Error("An account with this email already exists");
        User user = new User();
        user.setUsername(newUser.getUsername());
        user.setPassword(encoder.encode(newUser.getPassword()));
        user.setFirstName(newUser.getFirstName());
        user.setLastName(newUser.getLastName());
        user.setEmail(newUser.getEmail());
       return userRepo.save(newUser);

    }
/*    public User newUser(User newUser) throws Error {
        User exists = userRepo.findUserByemail(newUser.getEmail());
        if (exists != null) {
            throw new Error("An account with this email already exists");
        }
        User user = new User();
        user.setUsername(newUser.getUsername());
        user.setPassword(encoder.encode(newUser.getPassword()));
        user.setFirstName(newUser.getFirstName());
        user.setLastName(newUser.getLastName());
        user.setEmail(newUser.getEmail());
        return userRepo.save(newUser);

    }*/

        public User updateUser (UUID id, User user){
            User updatedUser = userRepo.findById(id).get();
            updatedUser.setPassword(/*pwEncoder.encode(*/user.getPassword());
            updatedUser.setEmail(user.getEmail());
            return userRepo.save(user);
        }


        public Optional<User> findUserById (UUID id){
            return userRepo.findById(id);
        }


        public boolean deleteUser (UUID id){
            try {
                userRepo.deleteById(id);
            } catch (Exception e) {
                System.out.println("User not found");
            }
            return true;
        }

        public Iterable<User> findAllUsers () {
            return userRepo.findAll();
        }

    }


