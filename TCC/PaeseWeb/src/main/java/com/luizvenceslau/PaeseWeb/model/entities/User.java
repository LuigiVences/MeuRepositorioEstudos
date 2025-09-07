package com.luizvenceslau.PaeseWeb.model.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.*;

@Getter
@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1)
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

    @Setter(AccessLevel.PROTECTED)
    @Column(name = "password_initialized")
    private boolean passwordInitialized = false;

    @Setter(AccessLevel.PROTECTED)
    @Column(name = "last_password_change_at")
    private LocalDateTime lastPasswordChangeAt;

    @Setter(AccessLevel.PROTECTED)
    @Column(name = "active")
    private boolean active = false;

    @Setter(AccessLevel.PROTECTED)
    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Setter(AccessLevel.PROTECTED)
    @CreatedBy
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by_id", updatable = false)
    private User createdBy;

    @Setter
    @Column(name = "deactivated_at")
    private LocalDateTime deactivatedAt;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deactivated_by_id")
    private User deactivatedBy;

    @Setter
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "organizational_unit_id")
    private OrganizationalUnit organizationalUnit;

    @OneToMany(mappedBy = "createdBy", fetch = FetchType.LAZY)
    private List<OrganizationalUnit> organizationalUnitsCreatedBy = new ArrayList<>();

    @OneToMany(mappedBy = "deactivatedBy", fetch = FetchType.LAZY)
    private List<OrganizationalUnit> organizationalUnitsDeactivatedBy = new ArrayList<>();


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<UserRole> userRoles = new HashSet<>();


    public void deactivation(){
        this.active = false;
        this.deactivatedAt = LocalDateTime.now();

    }

    public void activation(){
        this.active = true;
        this.passwordInitialized = true;
    }

    public void setPassword(String password, PasswordEncoder passwordEncoder){
        this.passwordHash = passwordEncoder.encode(password);
    }

}
