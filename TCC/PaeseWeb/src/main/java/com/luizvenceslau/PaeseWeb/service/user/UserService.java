package com.luizvenceslau.PaeseWeb.service.user;

import com.luizvenceslau.PaeseWeb.model.entities.User;
import com.luizvenceslau.PaeseWeb.repository.UserRepository;
import com.luizvenceslau.PaeseWeb.web.user.CreateUserDto;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(CreateUserDto userDto){
        if (userRepository.existsByEmail(userDto.email())){
            throw new IllegalArgumentException("Email já cadastrado");
        }

        User user = new User();
        user.setName(userDto.name());
        user.setEmail(userDto.email());

        return userRepository.save(user);
    }
}
