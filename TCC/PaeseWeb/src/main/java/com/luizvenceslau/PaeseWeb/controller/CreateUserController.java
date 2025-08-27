package com.luizvenceslau.PaeseWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CreateUserController {

    @GetMapping("/user")
    public String createUser(){
        return "user/create_user";
    }
}
