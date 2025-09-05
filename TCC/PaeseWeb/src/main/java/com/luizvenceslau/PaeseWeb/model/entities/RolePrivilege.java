package com.luizvenceslau.PaeseWeb.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@Getter
@Entity
@Table(name = "roles_privileges")
@EntityListeners(AuditingEntityListener.class)
public class RolePrivilege {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "role_id")
    private Role role;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "privilege_id")
    private Privilege privilege;

    @CreationTimestamp
    @Column(name = "granted_at", updatable = false)
    private Instant grantedAt;

    @CreatedBy
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "granted_by_id", updatable = false)
    private User grantedBy;

    @Column(name = "active")
    private boolean active = true;

    @Column(name = "revoked_at")
    private Instant revokedAt;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "revoked_by_id")
    private User revokedBy;

    public RolePrivilege() {
    }

    public void revoke(){
        this.active = false;
        this.revokedAt = Instant.now();
    }
}
