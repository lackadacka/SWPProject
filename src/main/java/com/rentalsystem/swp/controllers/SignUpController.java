package com.rentalsystem.swp.controllers;

import com.rentalsystem.swp.POSTResponds.LoginData;
import com.rentalsystem.swp.dao.UserProfile;
import com.rentalsystem.swp.POSTResponds.UserProfileData;
import com.rentalsystem.swp.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.security.crypto.password.PasswordEncoder;


@RestController
public class SignUpController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public SignUpController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String showLogin(Model model) {
        model.addAttribute("", new LoginData());
        return "signup";
    }
    @RequestMapping("/signup")
    public void addNewUser(@ModelAttribute("") UserProfileData user, Model model) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email address already exists.");
        }

        UserProfile newUser = new UserProfile();
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setEmail(user.getEmail());
        newUser.setPhoneNumber(user.getPhoneNumber());

        newUser.setPassword(user.getPassword());
        userRepository.save(newUser);
    }

    @GetMapping(path="/allusers")
    public @ResponseBody Iterable<UserProfile> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }
}