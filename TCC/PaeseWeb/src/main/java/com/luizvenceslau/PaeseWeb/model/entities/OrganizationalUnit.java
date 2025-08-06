package com.luizvenceslau.PaeseWeb.model.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "organizational_units")
public class OrganizationalUnit extends BasicAttributes{

    @Setter
    @Column(name = "name", nullable = false, unique = true, length = 255)
    private String name;

    @Setter
    @Column(name = "type", nullable = false, length = 70)
    private String type;

    @Setter
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private OrganizationalUnit parent;

    @JsonManagedReference
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrganizationalUnit> children = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "organizationalUnit")
    private List<User> users = new ArrayList<>();

    public OrganizationalUnit() {
    }


}
