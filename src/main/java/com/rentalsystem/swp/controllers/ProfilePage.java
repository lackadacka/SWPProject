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
public class ProfilePage {

    private UserRepository userRepository;
    private ItemRepository itemRepository;

    @Autowired
    public ProfilePage(UserRepository userRepository, ItemRepository itemRepository) {

        this.userRepository = userRepository;
        this.itemRepository = itemRepository;
    }


    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String showProfile(@ModelAttribute("loginData") LoginData loginData, Model model) {


        model.addAttribute("loginData", loginData);
        UserProfile userProfile;

        if(userRepository.existsByEmail(loginData.getLogin())) {

            Optional<UserProfile> expected = userRepository.findByEmail(loginData.getLogin());
            userProfile = expected.get();

            if (userProfile.getPassword().equals(loginData.getPassword())) {

                model.addAttribute("userProfile", userProfile);
                List<ItemProfile> items = itemRepository.findAllByOwnerIs(userProfile.getEmail());
                Integer id = 0;

                model.addAttribute("items", items);
                model.addAttribute("id", id);

                return "profile";
            }
        }
        return "login";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    public String showAd(@ModelAttribute("id") Integer id, Model model) {
        model.addAttribute("id", id);

        ItemProfile itemProfile = itemRepository.getOne(id);
        model.addAttribute("itemProfile", itemProfile);
        return "profile";
    }
}