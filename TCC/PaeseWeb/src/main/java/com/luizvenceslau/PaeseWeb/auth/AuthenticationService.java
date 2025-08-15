package com.luizvenceslau.PaeseWeb.auth;

import com.luizvenceslau.PaeseWeb.security.UserAuthenticated;
import com.luizvenceslau.PaeseWeb.security.jwt.JwtService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;


    public AuthenticationService(JwtService jwtService, AuthenticationManeger authenticationManager) {
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public String authenticate(String email, String senha){
        var authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, senha)
        );

        var principal =  authentication.getPrincipal();
        if (principal instanceof UserAuthenticated user) {
            if (!user.isEnabled()) {
                throw new UserInactiveException("Usuário inativo");
            }
            
        } else{
            throw new AuthenticationException("Falha na autenticação");
        }
        return jwtService.generateToken(authentication);
        
    }
}
