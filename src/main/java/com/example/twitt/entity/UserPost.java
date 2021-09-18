package com.example.twitt.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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

    @Column(name = "comment_section")
    private String commentSection;

    @Column(name = "image_path")
    private String ImagePath;

//    @ManyToMany(mappedBy = "userPostList")
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    private List<MainUser> users;
}
