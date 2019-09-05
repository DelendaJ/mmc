package com.example.moneymanagement.services;

import com.example.moneymanagement.entities.Account;
import com.example.moneymanagement.entities.Profile;
import com.example.moneymanagement.repositories.ProfileRepository;
import com.example.moneymanagement.requestobject.ProfileRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public class ProfileService {


    private ProfileRepository profileRepo;


    @Autowired
    public ProfileService (ProfileRepository profileRepo) {
        this.profileRepo = profileRepo;

    }
    public Profile newProfile(ProfileRequest profile) {
        Optional<Profile> exists = Optional.ofNullable(profileRepo.findUserByemail(profile.getEmail()));
        if (exists.isPresent())
            throw new Error("An account with this email already exists");
        Profile newProfile = new Profile();

        String username = profile.getUsername();
        String password = profile.getPassword();
        String firstName = profile.getFirstName();
        String lastName = profile.getLastName();
        String email = profile.getEmail();
        Set<Account> account = profile.getAccounts();

        newProfile.setUsername(username);
        newProfile.setPassword(password);
        newProfile.setFirstName(firstName);
        newProfile.setLastName(lastName);
        newProfile.setEmail(email);
        newProfile.setAccounts(account);
        return profileRepo.save(newProfile);

    }

    public Profile updateProfile(UUID id, ProfileRequest profile) {
        Profile currentProfile = profileRepo.findById(id).get();
        String password = profile.getPassword();
        String email = profile.getEmail();

        currentProfile.setPassword(password);
        currentProfile.setEmail(email);
        return profileRepo.save(currentProfile);
    }


    public Optional<Profile> findProfileById(UUID id) {
        return profileRepo.findById(id);
    }


    public boolean deleteProfile(UUID id) {
        try {
            profileRepo.deleteById(id);
        } catch (Exception e) {
            System.out.println("Profile not found");
        }
        return true;
    }

    public Iterable<Profile> findAllProfiles() {
        return profileRepo.findAll();
    }


}


