package com.luizvenceslau.PaeseWeb.login.dto;

public record LoginResponse(

    String tokenAcess, 
    
    Long expiresIn) {

}
