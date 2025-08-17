package com.luizvenceslau.PaeseWeb.exception;

public class UserInactiveException extends RuntimeException{
    public UserInactiveException(String message){
        super(message);
    }
}
