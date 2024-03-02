package com.sorteio.raffleapi.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sorteio.raffleapi.services.AuthenticationService;

@RestController("api/authenticate")
public class AuthenticationController {
    
    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping
    public String authenticate(Authentication authentication){
        return authenticationService.authenticate(authentication);
    }
}