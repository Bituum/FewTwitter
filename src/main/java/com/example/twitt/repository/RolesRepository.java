package com.example.twitt.repository;

import com.example.twitt.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RolesRepository extends JpaRepository<Roles, Integer> {

    @Query(nativeQuery = true, value = "delete from user_roles where fr_user = :value")
    void deleteUserRolesById(@Param("value") int id);

    @Query(nativeQuery = true, value = "delete from user_posts where user_fk = :value")
    void deleteUserPostsById(@Param("value") int id);

}
