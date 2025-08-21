package com.luizvenceslau.PaeseWeb.auth;

import com.luizvenceslau.PaeseWeb.security.jwt.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    /*

    Classe não será usada pois a autenticação não será com JWT

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthenticationService(JwtService jwtService, AuthenticationManager authenticationManager) {
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public String authenticate(String email, String senha) {
        var authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, senha)
        );

        return jwtService.generateToken(authentication);
        
    }

     */
}
