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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "photoPath")
    @Size(max = 255)
    private String photoPath;

    @ManyToOne
    @JoinColumn(
            name = "id",
            updatable = false,
            insertable = false
    )
    private MainUser user;
}
