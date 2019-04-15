package com.rentalsystem.swp.controllers;

import com.rentalsystem.swp.models.ItemProfile;
import com.rentalsystem.swp.repositories.ItemRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class MainController {

    private final ItemRepository itemRepository;

    public MainController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }


    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String showCatalog(Model model) {
        List<ItemProfile> list = itemRepository.findAll();
        Integer id = 0;
        model.addAttribute("items", list);
        model.addAttribute("id", id);
        return "main";
    }

    @RequestMapping(value = "/main", method = RequestMethod.POST)
    public String showCatalog(@ModelAttribute("id") Integer id, Model model) {
        model.addAttribute("id", id);

        ItemProfile itemProfile = itemRepository.getOne(id);
        model.addAttribute("itemProfile", itemProfile);
        return "ad";
    }

}
