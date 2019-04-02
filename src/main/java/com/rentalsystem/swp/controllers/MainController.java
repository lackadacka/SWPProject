package com.rentalsystem.swp.controllers;

import com.rentalsystem.swp.Repositories.ItemRepository;
import com.rentalsystem.swp.dao.ItemProfile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
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
        model.addAttribute("itemsList", list);
        return "main";
    }
}
