package com.luizvenceslau.PaeseWeb.web.user;

import com.luizvenceslau.PaeseWeb.validation.ValidEmail;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;

@Validated
public record CreateUserDto(
        @ValidEmail
        @NotBlank(message = "O e-mail é obrigatório")
        @Size(min = 3, max = 100)
        String email,

        @NotBlank(message = "O nome é obrigatório")
        @Size(min = 3, max = 100 )
        String name) {
}
