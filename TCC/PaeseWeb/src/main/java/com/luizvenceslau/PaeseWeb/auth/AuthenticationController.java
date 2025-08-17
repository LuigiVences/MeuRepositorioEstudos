package com.luizvenceslau.PaeseWeb.auth;

import com.luizvenceslau.PaeseWeb.auth.dto.LoginRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.AuthenticationException;

@RestController
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/authenticate")
    public String authenticate(@RequestBody @Valid LoginRequest loginRequest) throws AuthenticationException {
        return authenticationService.authenticate(loginRequest.email(), loginRequest.password());
    }
}
