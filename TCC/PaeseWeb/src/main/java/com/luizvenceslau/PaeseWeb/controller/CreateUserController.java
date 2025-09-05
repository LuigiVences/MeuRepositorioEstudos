package com.luizvenceslau.PaeseWeb.controller;

import com.luizvenceslau.PaeseWeb.service.user.UserService;
import com.luizvenceslau.PaeseWeb.web.user.CreateUserDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CreateUserController {

    private final UserService service;

    public CreateUserController(UserService service) {
        this.service = service;
    }


    @GetMapping("/user/new")
    public String showForm(Model model){
        model.addAttribute("userDto", new CreateUserDto(null, null));
        return "user/create_user";
    }

    @PostMapping("/user/new")
    public String createUser(@Valid @ModelAttribute("userDto") CreateUserDto userDto,
                             BindingResult result,
                             Model model){
        if (result.hasErrors()){
            return "user/create_user";
        }

        try {
            service.createUser(userDto);
            model.addAttribute("successMessage", "Usuário criado com sucesso!");
            model.addAttribute("userDto", new CreateUserDto(null, null)); // limpa o form
        } catch (IllegalArgumentException e) {
            result.rejectValue("email", "error.userDto", e.getMessage());
        }

        return "user/create_user";
    }

}
