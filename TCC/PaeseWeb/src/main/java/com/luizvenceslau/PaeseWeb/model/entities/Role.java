package com.luizvenceslau.PaeseWeb.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.HashSet;
import java.util.Set;


@Getter
@Entity
@Table(name = "roles")
public class Role extends BasicAttributes implements GrantedAuthority {

    @Setter
    @Column(name = "name", nullable = false, length = 100, unique = true)
    private String name;

    @Setter
    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<UserRole> userRoles = new HashSet<>();

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<RolePrivilege> rolePrivilegeSet = new HashSet<>();

    public Role() {
    }

    @Override
    public String getAuthority() {
        return name;
    }

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_seq")
    @SequenceGenerator(name = "role_seq", sequenceName = "role_seq", allocationSize = 1)
    @Override
    public Long getId() {
        return super.getId();
    }
}
