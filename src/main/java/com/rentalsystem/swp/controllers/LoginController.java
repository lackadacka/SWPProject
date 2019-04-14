package com.rentalsystem.swp.controllers;

import com.rentalsystem.swp.POSTResponds.LoginData;
import com.rentalsystem.swp.Repositories.ItemRepository;
import com.rentalsystem.swp.Repositories.UserRepository;
import com.rentalsystem.swp.dao.ItemProfile;
import com.rentalsystem.swp.dao.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;
import java.util.Optional;



@Controller
@SessionAttributes("loginData")
public class LoginController {

    private UserRepository userRepository;
    private ItemRepository itemRepository;

    @Autowired
    public LoginController(UserRepository userRepository, ItemRepository itemRepository) {

        this.userRepository = userRepository;
        this.itemRepository = itemRepository;
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLogin(Model model) {
        model.addAttribute("loginData", new LoginData());
        return "login";
    }

//    @RequestMapping(value = "/prof", method = RequestMethod.POST)
//    public String login(@ModelAttribute("loginData") LoginData loginData, Model model) {
//        model.addAttribute("loginData", loginData);
//
//        UserProfile userProfile;
//
//        if(userRepository.existsByEmail(loginData.getLogin())) {
//
//            Optional<UserProfile> expected = userRepository.findByEmail(loginData.getLogin());
//            userProfile = expected.get();
//
//            if (userProfile.getPassword().equals(loginData.getPassword())) {
//
//                model.addAttribute("userProfile", userProfile);
//                return "forward:/profile";
//            }
//        }
//        return "login";
//    }
}