package com.rentalsystem.swp.controllers;

import com.rentalsystem.swp.models.UserProfile;
import com.rentalsystem.swp.POSTResponds.UserProfileData;
import com.rentalsystem.swp.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.servlet.http.HttpSession;


@Controller
public class SignUpController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public SignUpController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String showSignup(Model model, HttpSession session){
        String currentUser = (String)session.getAttribute("currentUser");
        if (currentUser != null) {
            session.setAttribute("currentUser", null);
        }
        model.addAttribute("auth", "false");
        model.addAttribute("userProfileData", new UserProfileData());
        return "signup";
    }
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signUp(@ModelAttribute("userProfileData") UserProfileData userProfileData,
                         Model model, HttpSession session){
        String currentUser = (String)session.getAttribute("currentUser");
        if (currentUser == null) {
            model.addAttribute("auth", "false");
        }
        else
            model.addAttribute("auth", "true");
        model.addAttribute("UserProfileData", userProfileData);
        UserProfile user = new UserProfile(userProfileData.getFirstName(), userProfileData.getLastName(),
                userProfileData.getEmail(),userProfileData.getPassword(),userProfileData.getPhoneNumber());
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email address already exists.");
        }

        UserProfile newUser = new UserProfile();
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setEmail(user.getEmail());
        newUser.setPhoneNumber(user.getPhoneNumber());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(newUser);
        return "login";
    }

    @GetMapping(path="/allusers")
    public @ResponseBody Iterable<UserProfile> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }

}
