package com.luizvenceslau.PaeseWeb.security;

import com.luizvenceslau.PaeseWeb.model.entities.UserRole;

public class MyCustomUserDetails implements UserDetails {

    private final User user;

    public MyCustomUserDetails(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.getUserRoles()
                .stream()
                .filter(UserRole::isActive)
                .map(UserRole::getRole)
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
