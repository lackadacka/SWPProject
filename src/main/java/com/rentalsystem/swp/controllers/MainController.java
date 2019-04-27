package com.rentalsystem.swp.controllers;

import com.rentalsystem.swp.POSTResponds.SearchData;
import com.rentalsystem.swp.Repositories.ItemRepository;
import com.rentalsystem.swp.Repositories.UserRepository;
import com.rentalsystem.swp.models.ItemProfile;
import com.rentalsystem.swp.models.UserProfile;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@Controller
public class MainController {

    private final ItemRepository itemRepository;
    private final UserRepository userRepository;

    public MainController(ItemRepository itemRepository, UserRepository userRepository) {
        this.itemRepository = itemRepository;
        this.userRepository = userRepository;
    }

    private List<ItemProfile> getRequest(SearchData searchData){
        List<ItemProfile> result;
        List<ItemProfile> finalResult = new ArrayList<ItemProfile>();

        if (searchData.getCategory() == null){
            if (searchData.getTimeSlots() == null)
                result = itemRepository.findAll();
            else
                result = itemRepository.findAllByTimeSlots(searchData.getTimeSlots());
        }
        else{
            if (searchData.getTimeSlots() == null)
                result = itemRepository.findAllByCategory(searchData.getCategory());
            else
                result = itemRepository.findAllByTimeSlotsAndCategory(searchData.getTimeSlots(), searchData.getCategory());
        }

        if (searchData.getText() == null)
            return result;

        for (ItemProfile currentItem: result){
            if (currentItem.getDescription().contains(searchData.getText()))
                finalResult.add(currentItem);
            else {
                if (currentItem.getName().contains(searchData.getText()))
                    finalResult.add(currentItem);
            }
        }

        if (searchData.getSort() != null){
            int n = finalResult.size();

            for (int i = 0; i < n; i++){
                for (int j = i + 1; j < n; j++){
                    ItemProfile a = finalResult.get(i), b = finalResult.get(j);

                    if (a.getPrice() > b.getPrice())
                        Collections.swap(finalResult, i, j);
                }
            }
        }

        return finalResult;

    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showCatalog(@ModelAttribute("searchData") SearchData searchData, Model model, HttpSession session) {

        String test = (String) session.getAttribute("currentUser");
        session.setAttribute("uploadPath", System.getProperty("user.dir") + "//src//main//resources//img//");

        List<ItemProfile> list = getRequest(searchData);
        Integer id = 0;
        model.addAttribute("items", list);
        model.addAttribute("id", id);
        model.addAttribute("auth", Boolean.toString(test != null));

        return "main";
    }



    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String showCatalog(@ModelAttribute("id") Integer id, Model model, HttpSession session) {

        String test = (String) session.getAttribute("currentUser");

        model.addAttribute("id", id);
        model.addAttribute("auth", Boolean.toString(test != null));

        ItemProfile itemProfile = itemRepository.getOne(id);
        model.addAttribute("itemProfile", itemProfile);
        return "ad";
    }

}
