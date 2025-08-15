package com.luizvenceslau.PaeseWeb.security;

import com.luizvenceslau.PaeseWeb.model.entities.User;
import com.luizvenceslau.PaeseWeb.model.entities.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserAuthenticated implements UserDetails {

    private final User user;

    public UserAuthenticated(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.getUserRoles()
                .stream()
                .filter(UserRole::isActive)
                .flatMap(userRole -> {
                    Role role = userRole.getRole();
                    Stream<GrantedAuthority> roleAuth = Stream.of(new SimpleGrantedAuthority("ROLE_" + role.getName()));
                    Stream<GrantedAuthority> privilegeAuth = role.getPrivileges().stream()
                            .map(privilege -> new SimpleGrantedAuthority(privilege.getName()));
                    return Stream.concat(roleAuth, privilegeAuth);
                })
                .collect(Collectors.toSet());
    }

    @Override
    public String getPassword() {
        return user.getPasswordHash();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return user.isActive();
    }

    @Override
    public boolean isAccountNonLocked() {
        return user.isActive();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return user.isActive();
    }

    @Override
    public boolean isEnabled() {
        return user.isActive();
    }

    public User getUser(){
        return user;
    }

}
