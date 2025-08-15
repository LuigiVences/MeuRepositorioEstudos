package com.luizvenceslau.PaeseWeb.exception;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserInactiveException.class)
    public ResponseEntity<String> handlerUserInactive(UserInactiveException ex){
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(ex.getMessage());
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<String> handlerAuthenticationException(AuthenticationException ex){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handlerGenericException(GenericException ex){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body("Ocorreu um erro interno: " + ex.getMessage());
    }


}
