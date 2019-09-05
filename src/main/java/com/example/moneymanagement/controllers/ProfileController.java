package com.example.moneymanagement.controllers;

import com.example.moneymanagement.entities.Profile;
import com.example.moneymanagement.requestobject.ProfileRequest;
import com.example.moneymanagement.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/api/profile")
public class ProfileController {

    private ProfileService profileService;


    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;

    }

    @PostMapping("/sign-up")
    public ResponseEntity<Profile> newProfile(@RequestBody ProfileRequest newUser) {
        return new ResponseEntity<>(profileService.newProfile(newUser), HttpStatus.CREATED);
    }

    @GetMapping("/profile/{id}")
    public ResponseEntity<Optional<Profile>> getProfile(@PathVariable UUID id) {
        return new ResponseEntity<>(profileService.findProfileById(id), HttpStatus.OK);
    }

    @GetMapping("/profiles")
    public ResponseEntity<Iterable<Profile>> findAllProfiles() {
        return new ResponseEntity<>(profileService.findAllProfiles(), HttpStatus.OK);
    }

    @PutMapping("/profile/{id}")
    public ResponseEntity<Profile> updateProfile(@PathVariable UUID id, @RequestBody ProfileRequest user) {
        return new ResponseEntity<>(profileService.updateProfile(id, user), HttpStatus.OK);
    }

    @DeleteMapping("/profile/{id}")
    public ResponseEntity<Boolean> deleteProfile(@PathVariable UUID id) {
        return new ResponseEntity<>(profileService.deleteProfile(id), HttpStatus.OK);
    }


}
