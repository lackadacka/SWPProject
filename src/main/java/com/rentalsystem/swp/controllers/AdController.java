package com.rentalsystem.swp.controllers;

import com.rentalsystem.swp.Repositories.ItemRepository;
import com.rentalsystem.swp.Repositories.UserRepository;
import com.rentalsystem.swp.dao.ItemProfile;
import com.rentalsystem.swp.dao.UserProfile;
import com.rentalsystem.swp.security.ParserToken;
import com.rentalsystem.swp.security.TokenAuthenticationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Controller
public class AdController {

    private final ItemRepository itemRepository;
    private final UserRepository userRepository;

    public AdController(ItemRepository itemRepository, UserRepository userRepository) {
        this.itemRepository = itemRepository;
        this.userRepository = userRepository;
    }


    @RequestMapping(value = "/ad", method = RequestMethod.GET)
    public String showAd(@RequestParam(name = "id", required = false, defaultValue = "") Integer id, Model model, HttpServletRequest request) {
        ParserToken token = TokenAuthenticationService.getAuthentication(request);
        if(token == null) return "login";

        model.addAttribute("id", id);
        Optional<ItemProfile> item = itemRepository.findById(id);
        ItemProfile itemProfile  = item.get();
        Optional<UserProfile> user = userRepository.findByEmail(itemProfile.getOwner());
        UserProfile userProfile = user.get();
        model.addAttribute("userProfile", userProfile);
        model.addAttribute("itemProfile", itemProfile);
        return "ad";
    }

}
