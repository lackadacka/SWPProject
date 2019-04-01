package com.rentalsystem.swp.controllers;

import com.rentalsystem.swp.POSTResponds.LoginData;
import com.rentalsystem.swp.POSTResponds.LoginResponse;
import com.rentalsystem.swp.POSTResponds.UserProfileData;
import com.rentalsystem.swp.Repositories.UserRepository;
import com.rentalsystem.swp.configs.TokenAuthenticationProvider;
import com.rentalsystem.swp.models.Role;
import com.rentalsystem.swp.models.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserRepository userRepository;
    private final TokenAuthenticationProvider tokenProvider;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthController(UserRepository userRepository,
                          TokenAuthenticationProvider tokenProvider,
                          AuthenticationManager authenticationManager,
                          PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.tokenProvider = tokenProvider;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/signup")
    public UserProfileData signUp(@RequestBody UserProfileData user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email address is already in use.");
        }

        UserProfile userProfile = new UserProfile();
        userProfile.setEmail(user.getEmail());
        userProfile.setFirstName(user.getFirstName());
        userProfile.setLastName(user.getLastName());

        userProfile.setRole(Role.USER);
        userProfile.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.save(userProfile);

        return new UserProfileData (userProfile);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginData user) {
        try {
            Authentication auth = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(user.getLogin(), user.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(auth);

            String token = tokenProvider.createToken(auth);

            return new LoginResponse(token);
        } catch (AuthenticationException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid email or password.");
        }
    }
}