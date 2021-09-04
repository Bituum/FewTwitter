package com.example.twitt.entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "posts")
public class UserPost {
    @Id
    @NotNull
    @Column(name = "id")
    private int id;

    @Column(name = "commentSection")
    private String commentSection;

    @Column(name = "ImagePath")
    private String ImagePath;

    @ManyToOne
    private MainUser user;
}
