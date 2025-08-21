package com.luizvenceslau.PaeseWeb.auth;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthenticationController {

    /*
   private final AuthenticationService authenticationService;

   public AuthenticationController(AuthenticationService authenticationService) {
       this.authenticationService = authenticationService;
   }

   Esse metodo não será usado, pois a integração do spring secutiry com o thymeleaf já possui essa implementação

   @PostMapping("/authenticate")
   public String authenticate(@RequestBody @Valid LoginRequest loginRequest) throws AuthenticationException {
       return authenticationService.authenticate(loginRequest.email(), loginRequest.password());
   }

    */

    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout,
                        Model model) {

        if (error != null) {
            model.addAttribute("errorMessage", "Usuário ou senha inválidos.");
        }
        if (logout != null) {
            model.addAttribute("successMessage", "Você saiu do sistema com sucesso.");
        }

        return "authentication/login";
    }

}
