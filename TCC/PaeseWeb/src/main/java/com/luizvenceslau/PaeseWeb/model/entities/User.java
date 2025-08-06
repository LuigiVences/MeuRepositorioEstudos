package com.luizvenceslau.PaeseWeb.model.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.time.Instant;
import java.util.*;

@Getter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Setter
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Setter
    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;

    @Setter(AccessLevel.PROTECTED)
    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @Column(name = "active")
    private boolean active = false;

    @Setter(AccessLevel.PROTECTED)
    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    private Instant createdAt;

    @Setter(AccessLevel.PROTECTED)
    @CreatedBy
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by_id", updatable = false)
    private User createdBy;

    @Column(name = "deactivated_at")
    private Instant deactivatedAt;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deactivated_by_id")
    private User deactivatedBy;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organizational_unit_id")
    private OrganizationalUnit organizationalUnit;

    @OneToMany(mappedBy = "createdBy", fetch = FetchType.LAZY)
    private List<OrganizationalUnit> organizationalUnitsCreatedBy = new ArrayList<>();

    @OneToMany(mappedBy = "deactivatedBy", fetch = FetchType.LAZY)
    private List<OrganizationalUnit> organizationalUnitsDeactivatedBy = new ArrayList<>();


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<UserRole> userRoles = new HashSet<>();


    public void deactivation(){
        this.active = false;
        this.deactivatedAt = Instant.now();

    }

}
