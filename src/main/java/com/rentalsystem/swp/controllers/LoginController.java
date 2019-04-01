    package com.rentalsystem.swp.controllers;

    import com.rentalsystem.swp.POSTResponds.LoginData;
    import com.rentalsystem.swp.Repositories.UserRepository;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.security.crypto.password.PasswordEncoder;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.ModelAttribute;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RequestMethod;
    import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class LoginController {

    private UserRepository userRepository;

    @Autowired
    public LoginController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLogin(@RequestParam(name="name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("loginData", new LoginData());
        model.addAttribute("name", name);
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("loginData") LoginData loginData, Model model) {
        model.addAttribute("loginData", loginData);

        model.addAttribute("userProfile", userRepository.findByEmail(loginData.getLogin()));
        return "profile";
    }
}