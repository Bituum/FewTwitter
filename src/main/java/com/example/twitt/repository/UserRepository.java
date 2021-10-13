package com.example.twitt.repository;


import com.example.twitt.entity.MainUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<MainUser, Integer> {
    boolean findByLogin(String login);

    Optional<MainUser> findMainUsersByLogin(String login);

    MainUser getMainUserByLogin(String login);
}
