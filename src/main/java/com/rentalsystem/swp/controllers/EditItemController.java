
package com.rentalsystem.swp.controllers;

import com.rentalsystem.swp.POSTResponds.LoginData;
import com.rentalsystem.swp.Repositories.UserRepository;
import com.rentalsystem.swp.models.ItemProfile;
import com.rentalsystem.swp.Repositories.ItemRepository;
import com.rentalsystem.swp.models.UserProfile;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes({"id", "loginData"})
public class EditItemController {
    @Autowired
    private final ItemRepository itemRepository;
    private final UserRepository userRepository;

    public EditItemController(ItemRepository itemRepository, UserRepository userRepository) {
        this.itemRepository = itemRepository;
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "/edititem", method = RequestMethod.GET)
    public String showItem(@ModelAttribute("id") Integer id, Model model, HttpSession session) {

        String test = (String) session.getAttribute("currentUser");

        if (test == null){
            model.addAttribute("auth", "false");
            return "forward:/main";
        }
        else {
            UserProfile userProfile = userRepository.findByEmail(test).get();

            ItemProfile itemProfile;
            itemProfile = itemRepository.findById(id).get();

            model.addAttribute("id", id);
            model.addAttribute("itemProfile", itemProfile);
            model.addAttribute("auth", "true");
            model.addAttribute("userProfile", userProfile);

            return "forward:/edititem";
        }
    }



    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteItem(@ModelAttribute("id") Integer id,
                             Model model, HttpSession session) {

        String test = (String) session.getAttribute("currentUser");

        if (test == null) {
            model.addAttribute("auth", "false");
            return "forward:/main";
        }
        else {

            UserProfile userProfile = userRepository.findByEmail(test).get();

            model.addAttribute("id", id);
            model.addAttribute("auth", "true");
            model.addAttribute("userProfile", userProfile);

            itemRepository.deleteById(id);

            return "forward:/profile";
        }
    }

    @RequestMapping(value = "/edititem", method = RequestMethod.POST)
    public String editItem(@ModelAttribute("id") Integer id,
            @ModelAttribute("itemProfile") ItemProfile itemProfile, Model model,  HttpSession session) {

        String test = (String) session.getAttribute("currentUser");

        if (test == null) {
            model.addAttribute("auth", "false");
            return "forward:/main";
        }
        else {
            UserProfile userProfile = userRepository.findByEmail(test).get();

            model.addAttribute("auth", "true");
            model.addAttribute("ItemProfile", itemProfile);
            model.addAttribute("userProfile", userProfile);

            itemProfile.setOwner(test);

            itemRepository.deleteById(id);
            itemRepository.save(itemProfile);

            return "forward:/profile";
        }
    }

}

