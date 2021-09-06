package com.example.twitt.service;

import com.example.twitt.entity.MainUser;
import com.example.twitt.exception.UsernameIsTakenException;
import com.example.twitt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements CRUDService<MainUser>, UserDetailsService {
    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public MainUser addOne(MainUser user) {
        if(repository.findByLogin(user.getLogin())){
            throw new UsernameIsTakenException("Username is already been taken: " + user.getLogin());
        }


        repository.save(user);
        return user;
    }

    @Override
    public void deleteOneById(int id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteOne(MainUser user) {
        repository.delete(user);
    }

    @Override
    public List<MainUser> getAll() {
        return repository.findAll();
    }

    @Override
    public MainUser getOneById(int id) {
        return repository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("NOT FOUND")
        );
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<MainUser> user = repository.findMainUsersByLogin(s);
        if(user.isPresent()){
            Set<GrantedAuthority> grantedAuthorities = user.get().getRoles()
                    .stream()
                    .map(role -> new SimpleGrantedAuthority(role.getRole()))
                    .collect(Collectors.toSet());
            return new User(
                    user.get().getLogin(),
                    user.get().getPassword(),
                    user.get().getAuthorities()
            );
        }
        return null;


    }
}
