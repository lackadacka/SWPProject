package com.rentalsystem.swp.controllers;

import com.rentalsystem.swp.POSTResponds.LoginData;
import com.rentalsystem.swp.POSTResponds.UserProfileData;
import com.rentalsystem.swp.Repositories.ItemRepository;
import com.rentalsystem.swp.Repositories.UserRepository;
import com.rentalsystem.swp.models.UserProfile;
import com.rentalsystem.swp.security.JwtTokenProvider;
import com.rentalsystem.swp.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;


@Controller
public class LoginController {

    @Autowired
    JwtTokenProvider tokenProvider;
    @Autowired
    AuthenticationManager authenticationManager;

    private UserRepository userRepository;
    private ItemRepository itemRepository;

    @Autowired
    public LoginController(UserRepository userRepository, ItemRepository itemRepository) {

        this.userRepository = userRepository;
        this.itemRepository = itemRepository;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showSignup(Model model, HttpSession session){
        String currentUser = (String) session.getAttribute("currentUser");
        if (currentUser == null) {
            model.addAttribute("auth", "false");
        }
        else {
            model.addAttribute("auth", "true");
        }
        model.addAttribute("loginData", new LoginData());
        return "login";
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String showLogin(Model model, LoginData loginData, HttpSession session) {
        model.addAttribute("loginData", new LoginData());

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginData.getEmail(),
                        loginData.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);

        String username;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }
        session.setAttribute("currentUser", username);

        return "redirect:/profile";

    }

//    @RequestMapping(value = "/prof", method = RequestMethod.POST)
//    public String login(@ModelAttribute("loginData") LoginData loginData, Model model) {
//        model.addAttribute("loginData", loginData);
//
//        UserProfile userProfile;
//
//        if(userRepository.existsByEmail(loginData.getLogin())) {
//
//            Optional<UserProfile> expected = userRepository.findByEmail(loginData.getLogin());
//            userProfile = expected.get();
//
//            if (userProfile.getPassword().equals(loginData.getPassword())) {
//
//                model.addAttribute("userProfile", userProfile);
//                return "forward:/profile";
//            }
//        }
//        return "login";
//    }
}