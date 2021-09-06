package com.example.twitt.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "roles", schema = "public", catalog = "d2rs1nv1iqngad")
@Getter
@Setter
@NoArgsConstructor
public class Roles implements GrantedAuthority {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    @Size(max = 10)
    @Column(name = "role")
    private String role;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user-roles",
            joinColumns = @JoinColumn(
                    name = "fr_roles", referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "fr_user", referencedColumnName = "id"
            )
    )
    private List<MainUser> users;

    @Override
    public String getAuthority() {
        return getRole();
    }
}
