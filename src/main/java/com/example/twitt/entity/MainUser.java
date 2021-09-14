package com.example.twitt.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "user", schema = "public", catalog = "d2rs1nv1iqngad")
public class MainUser implements UserDetails{
    @Id
    @NotNull
    @Column(name = "id")
    private int id;

    @Basic
    @NotNull
    @Size(max = 255)
    @Column(name = "login")
    private String login;

    @Basic
    @NotNull
    @Column(name = "password")
    private String password;

    @ManyToMany
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(
                    name = "fr_user", referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "fr_roles", referencedColumnName = "id"
            )
    )
    private Set<Roles> roles;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private UserExtension extension;

    @OneToMany(
            mappedBy = "users",
            cascade = CascadeType.ALL)
    private List<UserPost> userPostList;

    @Column(name = "photos")
    @Size(max = 255)
    private String ImagePath;

    @Override

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream().map(
                x -> new SimpleGrantedAuthority(x.getAuthority())
        ).collect(Collectors.toList());
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
