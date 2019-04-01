package com.rentalsystem.swp.controllers;

import com.rentalsystem.swp.POSTResponds.LoginData;
import com.rentalsystem.swp.Repositories.UserRepository;
import com.rentalsystem.swp.dao.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;



@Controller
public class LoginController {

    private UserRepository userRepository;

    @Autowired
    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLogin(Model model) {
        model.addAttribute("loginData", new LoginData());
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("loginData") LoginData loginData, Model model) {
        model.addAttribute("loginData", loginData);
        model.addAttribute("userProfile", userRepository.findByEmail(loginData.getLogin()));

        UserProfile userProfile;

        if(userRepository.existsByEmail(loginData.getLogin())) {
            Optional<UserProfile> expected = userRepository.findByEmail(loginData.getLogin());
            userProfile = expected.get();
            if (userProfile.getPassword().equals(loginData.getPassword())) {
                return "profile?login="+loginData.getLogin();
            }
        }
        return "login?fail=true";

    }
}