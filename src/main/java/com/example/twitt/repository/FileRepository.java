package com.example.twitt.repository;

import com.example.twitt.entity.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<FileEntity, Integer> {

}
