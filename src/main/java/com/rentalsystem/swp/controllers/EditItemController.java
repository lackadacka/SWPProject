
package com.rentalsystem.swp.controllers;

import com.rentalsystem.swp.dao.ItemProfile;
import com.rentalsystem.swp.POSTResponds.ItemProfileData;
import com.rentalsystem.swp.Repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("id")
public class EditItemController {
    @Autowired
    private final ItemRepository itemRepository;

    public EditItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @RequestMapping(value = "/edititem", method = RequestMethod.GET)
    public String showItem(@ModelAttribute("id") Integer id, Model model){
        model.addAttribute("id", id);
        ItemProfile itemProfile;
        if (itemRepository.existsById(id)) {
            itemProfile = itemRepository.findById(id).get();
        }
        else {
            itemProfile = new ItemProfile("", "", "", 0, "", "da@yandex.ru");
        }
        model.addAttribute("itemProfile", itemProfile);
        return "edititem";
    }

    @RequestMapping(value = "/edititem", method = RequestMethod.POST)
    public String editItem(@ModelAttribute("id") Integer id,
            @ModelAttribute("itemProfile") ItemProfile itemProfile, Model model){
        model.addAttribute("ItemProfile",  itemProfile);
        itemRepository.deleteById(id);
//        ItemProfile newItem = new ItemProfile();
//        newItem.setName(item.getName());
//        newItem.setDescription(item.getNametDescription());
//        newItem.setTimeSlots(item.getTimeSlots());
//        newItem.setCategory(item.getCategory()).;

        itemRepository.save(itemProfile);
        return "login";
    }

}

