package com.example.twitt.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "posts")
@Getter
@Setter
@NoArgsConstructor
public class UserPost {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "commentSection")
    private String commentSection;

    @Column(name = "ImagePath")
    private String ImagePath;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "id",
            updatable = false,
            insertable = false
    )
    private MainUser users;
}
