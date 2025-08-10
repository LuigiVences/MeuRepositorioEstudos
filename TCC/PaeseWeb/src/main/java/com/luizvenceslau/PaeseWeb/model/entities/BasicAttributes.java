package com.luizvenceslau.PaeseWeb.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BasicAttributes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Setter(AccessLevel.PROTECTED)
    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    protected LocalDateTime createdAt;

    @Column(name = "deactivated_at")
    protected LocalDateTime deactivatedAt;

    @Setter(AccessLevel.PROTECTED)
    @JsonIgnore
    @CreatedBy
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by_id", updatable = false)
    protected User createdBy;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deactivated_by_id")
    @Setter
    protected User deactivatedBy;

    @Column(name = "active")
    protected boolean active = true;

    protected BasicAttributes(){}

    public void deactivation(){
        this.active = false;
        this.deactivatedAt = LocalDateTime.now();
    }

}
