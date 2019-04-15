package com.rentalsystem.swp.controllers;

import com.rentalsystem.swp.Repositories.ItemRepository;
import com.rentalsystem.swp.Repositories.UserRepository;
import com.rentalsystem.swp.models.ItemProfile;
import com.rentalsystem.swp.models.UserProfile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@SessionAttributes({"id", "userProfile"})
public class AdController {

    private final ItemRepository itemRepository;
    private final UserRepository userRepository;

    public AdController(ItemRepository itemRepository, UserRepository userRepository) {
        this.itemRepository = itemRepository;
        this.userRepository = userRepository;
    }


    @RequestMapping(value = "/ad", method = RequestMethod.GET)
    public String showAd(
            @RequestParam(name = "id", required = false, defaultValue = "")
                    Integer id,
            Model model, HttpSession session) {
        String currentUser = (String) session.getAttribute("currentUser");
        if (currentUser == null) {
            model.addAttribute("auth", "false");
        }
        else {
            model.addAttribute("auth", "true");
            model.addAttribute("currentUser", currentUser);
        }
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
