package com.luizvenceslau.PaeseWeb.security;

import com.luizvenceslau.PaeseWeb.model.entities.Role;
import com.luizvenceslau.PaeseWeb.model.entities.User;
import com.luizvenceslau.PaeseWeb.model.entities.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class UserAuthenticated implements UserDetails {

    private final User user;
    private Set<GrantedAuthority> authorities = new HashSet<>();

    public UserAuthenticated(User user) {
        this.user = user;
        this.authorities = authorities;
    }

    private Set<GrantedAuthority> buildAuthorities(User user){
        Set<GrantedAuthority> auths = new HashSet<>();
        user.getUserRoles().stream()
                .filter(UserRole::isActive)
                .forEach(userRole -> {
                    Role role = userRole.getRole();
                    auths.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
                    if(role.getRolePrivilegeSet() != null) {
                        role.getRolePrivilegeSet().forEach(rolePrivilege -> {
                            auths.add(new SimpleGrantedAuthority(rolePrivilege.getPrivilege().getName()));
                        });
                    }
                });
        return auths;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
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
