package com.luizvenceslau.PaeseWeb.security;

import com.luizvenceslau.PaeseWeb.repository.UserRepository;

@Service
public class MyCustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public MyCustomUserDetailsService(UserRepository userRepository){

        this.userRepository = userRepository;

    }

    @Override
    public MyCustomUserDetails loadUserByUsername(String email) throws UsernameNotFoundException{

        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("Usuário com o e-mail: " + email + " não foi encontrado.");
        }

        return new MyCustomUserDetails(user);

    }

}
