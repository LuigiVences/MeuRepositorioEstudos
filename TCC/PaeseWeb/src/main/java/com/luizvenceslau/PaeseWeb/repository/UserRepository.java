package com.luizvenceslau.PaeseWeb.repository;

import com.luizvenceslau.PaeseWeb.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
