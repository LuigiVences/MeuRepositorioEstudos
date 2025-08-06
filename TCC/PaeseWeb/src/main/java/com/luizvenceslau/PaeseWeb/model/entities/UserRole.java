package com.luizvenceslau.PaeseWeb.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedBy;

import java.time.Instant;

@Getter
@Entity
@Table(name = "users_roles")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "role_id")
    private Role role;

    @CreationTimestamp
    @Column(name = "granted_at", updatable = false)
    private Instant grantedAt;

    @CreatedBy
    @ManyToOne
    @JoinColumn(name = "granted_by_id", updatable = false)
    private User grantedBy;

    @Column(name = "active")
    private boolean active = true;

    @Column(name = "revoked_at")
    private Instant revokedAt;

    @ManyToOne
    @JoinColumn(name = "revoked_by_id")
    private User revokedBy;

    public UserRole() {
    }

    public void revoke(){
        this.active = false;
        this.revokedAt = Instant.now();
    }
}
