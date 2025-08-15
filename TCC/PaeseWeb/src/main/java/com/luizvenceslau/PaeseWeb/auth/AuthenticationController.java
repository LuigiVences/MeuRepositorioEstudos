package com.luizvenceslau.PaeseWeb.auth;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/authenticate")
    public String authenticate(@RequestBody @Valid LoginRequest loginRequest) {
        return authenticationService.authenticate(loginRequest.getEmail(), loginRequest.getSenha());
    }
}
