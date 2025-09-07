package com.luizvenceslau.PaeseWeb.service.user;

import com.luizvenceslau.PaeseWeb.model.entities.User;
import com.luizvenceslau.PaeseWeb.repository.UserRepository;
import com.luizvenceslau.PaeseWeb.web.user.CreateUserDto;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final EmailService emailService;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, EmailService emailService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.emailService = emailService;
    }

    public User createUser(CreateUserDto userDto){
        if (userRepository.existsByEmail(userDto.email())){
            throw new IllegalArgumentException("Email já cadastrado");
        }

        User user = new User();

        String tempPassword = TempPasswordGenerator.generateNumericPassword();
        user.setName(userDto.name());
        user.setEmail(userDto.email());
        user.setPassword(tempPassword, passwordEncoder);
        userRepository.save(user);
        emailService.sendEmail(user.getEmail(), tempPassword);
        return user;
    }
}
