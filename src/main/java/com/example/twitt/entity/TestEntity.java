package com.example.twitt.entity;


import lombok.*;
import net.minidev.json.annotate.JsonIgnore;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Basic
    @NotBlank(message = "name should be filled")
    private String name;
    @Basic
    @NotBlank(message = "department should be filled")
    private String department;
}
