package com.luizvenceslau.PaeseWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

    @GetMapping("/menu")
    public String homePage(){
        return "/menu/menu";
    }
}
