package com.rentalsystem.swp.controllers;

import com.rentalsystem.swp.models.ItemProfile;
import com.rentalsystem.swp.POSTResponds.ItemProfileData;
import com.rentalsystem.swp.Repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AddItemController {
    @Autowired
    private final ItemRepository itemRepository;

    public AddItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @RequestMapping(value = "/additem", method = RequestMethod.POST)
    public void addNewItem(@RequestBody ItemProfileData item){
        ItemProfile newItem = new ItemProfile();
        newItem.setName(item.getName());
        newItem.setDescription(item.getDescription());
        newItem.setTimeSlots(item.getTimeSlots());

        itemRepository.save(newItem);
    }

    @RequestMapping(value="/allitems", method = RequestMethod.GET)
    public @ResponseBody
    Iterable<ItemProfile> getAllItems() {
        // This returns a JSON or XML with the users
        return itemRepository.findAll();
    }



}
