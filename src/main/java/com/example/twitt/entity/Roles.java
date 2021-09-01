package com.example.twitt.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "roles", schema = "public", catalog = "d2rs1nv1iqngad")
public class Roles {
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Basic
    @Column(name = "role", length = 10)
    private String role;

    @ManyToMany
    @JoinTable(
            name = "user-roles",
            joinColumns = @JoinColumn(
                    name = "fr_roles", referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "fr_user", referencedColumnName = "id"
            )
    )
    private List<MainUser> users;

}
