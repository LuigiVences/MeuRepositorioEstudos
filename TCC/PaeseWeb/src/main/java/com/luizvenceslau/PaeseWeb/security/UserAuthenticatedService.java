package com.luizvenceslau.PaeseWeb.security;

import com.luizvenceslau.PaeseWeb.model.entities.User;
import com.luizvenceslau.PaeseWeb.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserAuthenticatedService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserAuthenticatedService(UserRepository userRepository){

        this.userRepository = userRepository;

    }

    @Override
    public UserAuthenticated loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("Usuário com o e-mail: " + email + " não foi encontrado.");
        }

        return new UserAuthenticated(user);

    }

}
