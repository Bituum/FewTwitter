package com.example.twitt.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "user", schema = "public", catalog = "d2rs1nv1iqngad")
public class MainUser {
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Basic
    @NotNull
    @Column(name = "login", length = 255)
    private String login;

    @Basic
    @NotNull
    @Column(name = "password", length = 50)
    private String password;

    @ManyToMany
    @JoinTable(
            name = "user-roles",
            joinColumns = @JoinColumn(
                    name = "fr_user", referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "fr_roles", referencedColumnName = "id"
            )
    )
    private Set<Roles> role;
}
