package com.example.twitt.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "file", schema = "public", catalog = "d2rs1nv1iqngad")
public class FileEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Lob
    @Column(name = "data")
    private byte[] data;

    public FileEntity(String name, String type, byte[] data) {
        this.name = name;
        this.type = type;
        this.data = data;
    }
}
