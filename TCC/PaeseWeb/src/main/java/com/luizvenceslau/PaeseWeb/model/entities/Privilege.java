package com.luizvenceslau.PaeseWeb.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Entity
@Table(name = "privileges")
public class Privilege extends BasicAttributes{

    @Setter
    @Column(name = "name", nullable = false, unique = true)
    private String name;
    @Setter
    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "privilege", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<RolePrivilege> rolePrivileges = new HashSet<>();

    public Privilege() {
    }

}
