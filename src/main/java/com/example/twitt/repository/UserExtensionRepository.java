package com.example.twitt.repository;

import com.example.twitt.entity.UserExtension;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserExtensionRepository extends JpaRepository<UserExtension, Integer> {
}
