package com.example.twitt.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

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

    @Column(name = "photo_path")
    @Size(max = 255)
    private String photoPath;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(
            name = "id",
            updatable = false,
            insertable = false
    )
    private MainUser user;
}
