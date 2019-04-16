package com.rentalsystem.swp.controllers;

import com.rentalsystem.swp.models.ItemProfile;
import com.rentalsystem.swp.POSTResponds.ItemProfileData;
import com.rentalsystem.swp.Repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

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


    @RequestMapping(value = "/additem", method = RequestMethod.GET)
    public String showItem(Model model, HttpSession session){
        String currentUser = (String) session.getAttribute("currentUser");
        if (currentUser == null) {
            return "redirect:/login";
        }
        else {
            model.addAttribute("auth", "true");
        }
        model.addAttribute("itemProfileData", new ItemProfileData());
        return "additem";
    }

    @RequestMapping(value = "/additem", method = RequestMethod.POST)
    public String addNewItem(@ModelAttribute("itemProfileData") ItemProfileData itemProfileData,
                             Model model, HttpSession session){
        String currentUser = (String)session.getAttribute("currentUser");
        if (currentUser == null) {
            return "redirect:/login";
        }
        model.addAttribute("auth", "true");
        model.addAttribute("ItemProfileData",  itemProfileData);
        ItemProfile item = new ItemProfile(itemProfileData.getName(), itemProfileData.getDescription(),
                                            itemProfileData.getTimeSlots(), itemProfileData.getPrice(),
                                            itemProfileData.getCategory(), currentUser);
        itemRepository.save(item);
        return "redirect:/profile";
    }


    @GetMapping(path="/allitems")
    public @ResponseBody
    Iterable<ItemProfile> getAllItems() {
        // This returns a JSON or XML with the users
        return itemRepository.findAll();
    }



}
