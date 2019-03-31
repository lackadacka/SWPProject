package com.rentalsystem.swp.controllers;

import com.rentalsystem.swp.dao.UserProfile;
import com.rentalsystem.swp.dao.UserProfileData;
import com.rentalsystem.swp.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class SignUpController {
    @Autowired
    private final UserRepository userRepository;

    public SignUpController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/signup")
    public void addNewUser(@RequestBody UserProfileData user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email address is already in use.");
        }

        UserProfile newUser = new UserProfile();
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        newUser.setPhoneNumber(user.getPhoneNumber());

        userRepository.save(newUser);
    }

    @GetMapping(path="/allusers")
    public @ResponseBody Iterable<UserProfile> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }
}
