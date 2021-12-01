package com.example.twitt.service;

import com.example.twitt.entity.MainUser;
import com.example.twitt.entity.Roles;
import com.example.twitt.exception.UsernameIsTakenException;
import com.example.twitt.exception.WrongUserLoginOrPasswordException;
import com.example.twitt.repository.RolesRepository;
import com.example.twitt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
@PropertySource("classpath:basicIcon.properties")
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private UserRepository repository;

    private static final Logger logger = Logger.getLogger(UserServiceImpl.class.getName());
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Value("${icon}")
    private String basicUserIcon;

    @Autowired
    private RolesRepository rolesRepository;

    @Override
    public MainUser addOne(MainUser user) {
        if (checkLogin(user.getLogin())) {
            throw new UsernameIsTakenException("username " + user.getUsername() + " is already been taken!");
        }
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Set<Roles> roleSet = new HashSet<>();
        roleSet.add(rolesRepository.getById(1));
        user.setRoles(roleSet);
        user.setImagePath(basicUserIcon);
        repository.save(user);
        return user;
    }

    public MainUser updateOne(MainUser updatedUser) {
        return repository.save(updatedUser);
    }

    @Override
    public void deleteOneById(int id) {
        rolesRepository.deleteUserRolesById(id);
        rolesRepository.deleteUserPostsById(id);
        repository.deleteById(id);
    }

    @Override
    public void deleteOne(MainUser user) {
        rolesRepository.deleteUserPostsById(user.getId());
        rolesRepository.deleteUserPostsById(user.getId());
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
                    .map(role -> new SimpleGrantedAuthority(role.getAuthority()))
                    .collect(Collectors.toSet());
            return new User(
                    user.get().getLogin(),
                    user.get().getPassword(),
                    user.get().getAuthorities()
            );
        }
        return null;
    }

    public MainUser checkUser(MainUser providedUser) {
        MainUser user = repository.getMainUserByLogin(providedUser.getLogin());
        if (user != null && bCryptPasswordEncoder
                .matches(providedUser.getPassword(), user.getPassword())) {
            return user;
        } else {
            throw new WrongUserLoginOrPasswordException("wrong login or password");
        }
    }

    private boolean checkLogin(String login) {
        Optional<MainUser> user = repository.findMainUsersByLogin(login);
        return user.isPresent();
    }
}
