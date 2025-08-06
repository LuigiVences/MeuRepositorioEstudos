package com.luizvenceslau.PaeseWeb.service.user;

import com.luizvenceslau.PaeseWeb.model.CustomUserDetails;
import com.luizvenceslau.PaeseWeb.model.entities.User;
import com.luizvenceslau.PaeseWeb.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = Optional.ofNullable(userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário com email: " + username +
                        " não foi encontrado")));
        return new CustomUserDetails(userOptional);
    }
}
