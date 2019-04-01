package com.rentalsystem.swp.controllers;

import com.rentalsystem.swp.dao.ItemProfile;
import com.rentalsystem.swp.POSTResponds.ItemProfileData;
import com.rentalsystem.swp.Repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AddItemController {
    @Autowired
    private final ItemRepository itemRepository;

    public AddItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping("/menu")
    public String menu(){
        return "headerMenu";
    }


    @RequestMapping("/additem")
    public String addNewItem(@ModelAttribute("") ItemProfileData item, Model model){
        ItemProfile newItem = new ItemProfile();
        newItem.setName(item.getName());
        newItem.setDescription(item.getDescription());
        newItem.setTimeSlots(item.getTimeSlots());

        itemRepository.save(newItem);
        return "additem";
    }


    @GetMapping(path="/allitems")
    public @ResponseBody
    Iterable<ItemProfile> getAllItems() {
        // This returns a JSON or XML with the users
        return itemRepository.findAll();
    }



}
