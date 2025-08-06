package com.example.spring_boot_api.infra;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/*Criamos um novo pacote chamado Infra, que conté, as classes referentes à infraestrutura
do projeto.
Usamos a notação @RestControler Advice para informar ao Spring que essa classe vai tratar os erros
nos Controllers*/
@RestControllerAdvice
public class TratarErros {

    /*Usamos a notação @ExceptionHandler para informar ao metodo que se trata de uma exceção
    em um Controller e como parâmetro, informamos o tipo de exceção que será capturada pelo
     metodo*/

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarErro404(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarErro400(MethodArgumentNotValidException ex){
        var erros = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(erros.stream()
                .map(DadosErroValidacao::new).toList());
    }

    private record DadosErroValidacao(String campo, String mensagem){

        public DadosErroValidacao(FieldError erro){
            this(erro.getField(), erro.getDefaultMessage());
        }
    }
}
