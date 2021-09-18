package com.example.twitt.repository;

import com.example.twitt.entity.UserPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<UserPost, Integer> {
    @Query(value = "select * from posts join user_posts on posts.id = user_posts.post_fk where user_fk = :var", nativeQuery = true)
    List<UserPost> getUserPostsByUserId(@Param("var") int id);
}
