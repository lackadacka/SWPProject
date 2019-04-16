
package com.rentalsystem.swp.controllers;

import com.rentalsystem.swp.POSTResponds.ItemProfileData;
import com.rentalsystem.swp.POSTResponds.LoginData;
import com.rentalsystem.swp.Repositories.UserRepository;
import com.rentalsystem.swp.models.ItemProfile;
import com.rentalsystem.swp.Repositories.ItemRepository;
import com.rentalsystem.swp.models.UserProfile;
import org.apache.catalina.User;
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
@SessionAttributes({"id", "loginData"})
public class EditItemController {
    @Autowired
    private final ItemRepository itemRepository;
    private final UserRepository userRepository;
    private String uploadPath = System.getProperty("user.dir") + "/src/main/resources/img/";

    public EditItemController(ItemRepository itemRepository, UserRepository userRepository) {
        this.itemRepository = itemRepository;
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "/edititem", method = RequestMethod.GET)
    public String showItem(@ModelAttribute("id") Integer id, Model model, HttpSession session) {

        String test = (String) session.getAttribute("currentUser");

        if (test == null){
            model.addAttribute("auth", "false");
            return "forward:/main";
        }
        else {
            UserProfile userProfile = userRepository.findByEmail(test).get();

            ItemProfile itemProfile;
            itemProfile = itemRepository.findById(id).get();
            ItemProfileData itemProfileData = new ItemProfileData();
            itemProfileData.setId(id);
            itemProfileData.setName(itemProfile.getName());
            itemProfileData.setDescription(itemProfile.getDescription());
            itemProfileData.setTimeSlots(itemProfile.getTimeSlots());
            itemProfileData.setPrice(itemProfile.getPrice());
            itemProfileData.setCategory(itemProfile.getCategory());
            itemProfileData.setOwner(itemProfile.getOwner());


            model.addAttribute("id", id);
            model.addAttribute("itemProfileData", itemProfileData);
            model.addAttribute("auth", "true");
            model.addAttribute("userProfile", userProfile);

            return "edititem";
        }
    }



    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteItem(@ModelAttribute("id") Integer id,
                             Model model, HttpSession session) {

        String test = (String) session.getAttribute("currentUser");

        if (test == null) {
            model.addAttribute("auth", "false");
            return "forward:/main";
        }
        else {

            UserProfile userProfile = userRepository.findByEmail(test).get();

            model.addAttribute("id", id);
            model.addAttribute("auth", "true");
            model.addAttribute("userProfile", userProfile);

            itemRepository.deleteById(id);

            return "forward:/profile";
        }
    }

    @RequestMapping(value = "/edititem", method = RequestMethod.POST)
    public String editItem(@ModelAttribute("id") Integer id,
            @ModelAttribute("itemProfileData") ItemProfileData itemProfile, Model model,
                           HttpSession session) throws IOException {

        String test = (String) session.getAttribute("currentUser");

        if (test == null) {
            model.addAttribute("auth", "false");
            return "forward:/main";
        }
        else {

            model.addAttribute("auth", "true");
            model.addAttribute("itemProfileData", itemProfile);
            String filename = null;
            if (itemProfile.getFile() != null) {
                filename = UUID.randomUUID().toString() + "_" + itemProfile.getFile().getOriginalFilename();
                Path path = Paths.get(uploadPath + filename);
                byte[] bytes = itemProfile.getFile().getBytes();
                Files.write(path, bytes);
            }
            ItemProfile item = new ItemProfile(itemProfile.getName(), itemProfile.getDescription(),
                    itemProfile.getTimeSlots(), itemProfile.getPrice(),
                    itemProfile.getCategory(), test, filename);

            String oldFilename = itemRepository.getOne(id).getFile();
            if (oldFilename != null) {

                Path path = Paths.get(uploadPath + oldFilename);
                Files.delete(path);
            }
            itemRepository.deleteById(id);
            itemRepository.save(item);

            return "redirect:/profile";
        }
    }

}

