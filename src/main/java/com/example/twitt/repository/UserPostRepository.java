package com.example.twitt.repository;

import com.example.twitt.entity.UserPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPostRepository extends JpaRepository<UserPost, Integer> {

}
