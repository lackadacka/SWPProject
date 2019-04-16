package com.rentalsystem.swp.controllers;

import com.rentalsystem.swp.Repositories.ItemRepository;
import com.rentalsystem.swp.Repositories.UserRepository;
import com.rentalsystem.swp.models.ItemProfile;
import com.rentalsystem.swp.models.UserProfile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MainController {

    private final ItemRepository itemRepository;
    private final UserRepository userRepository;

    public MainController(ItemRepository itemRepository, UserRepository userRepository) {
        this.itemRepository = itemRepository;
        this.userRepository = userRepository;
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showCatalog(Model model, HttpSession session) {

        String test = (String) session.getAttribute("currentUser");
        session.setAttribute("uploadPath", System.getProperty("user.dir") + "//src//main//resources//img//");

        List<ItemProfile> list = itemRepository.findAll();
        Integer id = 0;
        model.addAttribute("items", list);
        model.addAttribute("id", id);
        model.addAttribute("auth", Boolean.toString(test != null));

        return "main";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String showCatalog(@ModelAttribute("id") Integer id, Model model, HttpSession session) {

        String test = (String) session.getAttribute("currentUser");

        model.addAttribute("id", id);
        model.addAttribute("auth", Boolean.toString(test != null));

        ItemProfile itemProfile = itemRepository.getOne(id);
        model.addAttribute("itemProfile", itemProfile);
        return "ad";
    }

}
