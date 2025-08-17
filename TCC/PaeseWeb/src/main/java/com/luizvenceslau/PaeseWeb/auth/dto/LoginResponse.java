package com.luizvenceslau.PaeseWeb.auth.dto;

public record LoginResponse(

    String tokenAcess, 
    
    Long expiresIn) {

}
