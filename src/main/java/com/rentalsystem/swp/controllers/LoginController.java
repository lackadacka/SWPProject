package com.rentalsystem.swp.controllers;

import com.rentalsystem.swp.POSTResponds.LoginData;
import com.rentalsystem.swp.POSTResponds.UserProfileData;
import com.rentalsystem.swp.Repositories.UserRepository;
import com.rentalsystem.swp.dao.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

/*
@RestController
public class LoginController {
    private AuthenticationManager authenticationManager;
    private TokenAuthenticationProvider tokenProvider;


    @PostMapping("/login")
    public LoginData loginUser(@RequestBody LoginData user){
        try {
            Authentication auth = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(user.getLogin(), user.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(auth);

            String token = tokenProvider.createToken(auth);

            return new LoginData(token);
        } catch (AuthenticationException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid email or password.");
        }



    }
}
*/


@Controller
public class LoginController {

    private UserRepository userRepository;

    @Autowired
    public LoginController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLogin(
            @RequestParam(name="error", required = false, defaultValue = "") String error,
            Model model) {
        model.addAttribute("loginData", new LoginData());
        model.addAttribute("error", error);
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("loginData") LoginData loginData, Boolean bool, Model model) {
        model.addAttribute("loginData", loginData);
        String email = loginData.getLogin();
        if (!userRepository.existsByEmail(email)) {
            return "login";
        }
        Optional<UserProfile> userProfile = userRepository.findByEmail(email);
        if (!userProfile.get().getPassword().equals(loginData.getPassword())) {
            return "login";
        }
        model.addAttribute("userProfile", userProfile);
        return "profile";
    }
}