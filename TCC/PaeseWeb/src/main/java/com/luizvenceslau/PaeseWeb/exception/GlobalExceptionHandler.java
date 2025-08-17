package com.luizvenceslau.PaeseWeb.exception;

import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.prefs.BackingStoreException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserInactiveException.class)
    public ResponseEntity<String> handlerUserInactive(UserInactiveException ex){
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(ex.getMessage());
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<String> handlerAuthenticationException(BadRequestException ex){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getMessage());
    }

    @ExceptionHandler(GenericException.class)
    public ResponseEntity<String> handlerGenericException(GenericException ex){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body("Ocorreu um erro interno: " + ex.getMessage());
    }


}
