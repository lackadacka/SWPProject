package com.rentalsystem.swp.dao;

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

    @PostMapping("/signup") // Map ONLY GET Requests
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

    @GetMapping(path="/all")
    public @ResponseBody Iterable<UserProfile> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }
}
