package com.rentalsystem.swp.controllers;

import com.rentalsystem.swp.models.ItemProfile;
import com.rentalsystem.swp.POSTResponds.ItemProfileData;
import com.rentalsystem.swp.Repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Controller
public class AddItemController {
    @Autowired
    private final ItemRepository itemRepository;

    private String uploadPath = System.getProperty("user.dir") + "/src/main/resources/img/";

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
                             Model model, HttpSession session) throws IOException {
        String currentUser = (String)session.getAttribute("currentUser");
        if (currentUser == null) {
            return "redirect:/login";
        }
        model.addAttribute("auth", "true");
        model.addAttribute("itemProfileData",  itemProfileData);
        String filename = null;
        if (!itemProfileData.getFile().getOriginalFilename().equals("")) {
            filename = UUID.randomUUID().toString() + "_" + itemProfileData.getFile().getOriginalFilename();
            Path path = Paths.get(uploadPath + filename);
            byte[] bytes = itemProfileData.getFile().getBytes();
            Files.write(path, bytes);
        }
        ItemProfile item = new ItemProfile(itemProfileData.getName(), itemProfileData.getDescription(),
                                            itemProfileData.getTimeSlots(), itemProfileData.getPrice(),
                                            itemProfileData.getCategory(), currentUser, filename);
        itemRepository.save(item);
        return "redirect:/profile";
    }
}
