package com.luizvenceslau.PaeseWeb.security;

import com.luizvenceslau.PaeseWeb.exception.UserInactiveException;
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
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(
                        "O usuário com o email: " + email + " não foi encontrado."));

        if (!user.isActive()){
            throw new UserInactiveException("Usuário inativo");
        }

        return new UserAuthenticated(user);
    }

}
