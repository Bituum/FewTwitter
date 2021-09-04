package com.example.twitt.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "photos")
@Getter
@Setter
@NoArgsConstructor
public class Photos {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "photoPath")
    @Size(max = 255)
    private String photoPath;

    @ManyToOne
    private MainUser user;
}
