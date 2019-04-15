
package com.rentalsystem.swp.controllers;

import com.rentalsystem.swp.POSTResponds.LoginData;
import com.rentalsystem.swp.Repositories.UserRepository;
import com.rentalsystem.swp.dao.ItemProfile;
import com.rentalsystem.swp.Repositories.ItemRepository;
import com.rentalsystem.swp.dao.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteItem(@ModelAttribute("id") Integer id,
                             Model model) {
        model.addAttribute("id", id);
        UserProfile userProfile = userRepository.findByEmail(itemRepository.findById(id).get().getOwner()).get();
        LoginData loginData = new LoginData();
        loginData.setLogin(userProfile.getEmail());
        loginData.setPassword(userProfile.getPassword());
        model.addAttribute("loginData", loginData);
        itemRepository.deleteById(id);
        return "forward:/profile";
    }

    @RequestMapping(value = "/edititem", method = RequestMethod.POST)
    public String editItem(@ModelAttribute("id") Integer id,
            @ModelAttribute("itemProfile") ItemProfile itemProfile, Model model){
        itemProfile.setOwner(itemRepository.findById(id).get().getOwner());
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

