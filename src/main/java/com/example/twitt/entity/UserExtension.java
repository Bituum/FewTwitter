package com.example.twitt.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user_extension")
@Getter
@Setter
@NoArgsConstructor
public class UserExtension {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @Size(max = 255)
    private String name;

    @Column(name = "second_name")
    @Size(max = 255)
    private String secondName;

    @Column(name = "patronymic")
    @Size(max = 255)
    private String patronymic;

    @Column(name = "hobby")
    @Size(max = 255)
    private String hobby;

    @Column(name = "friends")
    private int friends;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id")
    @MapsId
    @JsonBackReference
    private MainUser user;
}
