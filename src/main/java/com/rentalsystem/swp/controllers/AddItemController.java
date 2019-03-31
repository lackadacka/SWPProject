package com.rentalsystem.swp.controllers;

import com.rentalsystem.swp.dao.ItemProfile;
import com.rentalsystem.swp.dao.ItemProfileData;
import com.rentalsystem.swp.dao.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddItemController {
    @Autowired
    private final ItemRepository itemRepository;

    public AddItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @PostMapping("/additem")
    public void addNewItem(@RequestBody ItemProfileData item){
        ItemProfile newItem = new ItemProfile();
        newItem.setName(item.getName());
        newItem.setDescription(item.getDescription());

        itemRepository.save(newItem);
    }

    @GetMapping(path="/allitems")
    public @ResponseBody
    Iterable<ItemProfile> getAllItems() {
        // This returns a JSON or XML with the users
        return itemRepository.findAll();
    }



}
