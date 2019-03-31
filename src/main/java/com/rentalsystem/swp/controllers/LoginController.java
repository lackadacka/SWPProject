package com.rentalsystem.swp.controllers;

import com.rentalsystem.swp.POSTResponds.LoginData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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