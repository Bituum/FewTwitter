package com.example.twitt.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
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
    @Size(max = 255)
    @Column(name = "login")
    private String login;

    @Basic
    @NotNull
    @Size(max = 50)
    @Column(name = "password")
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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private UserExtension extension;

    @OneToMany(fetch = FetchType.LAZY)
    private List<UserPost> userPostList;
    @OneToMany()
    private List<Photos> photos;
}
