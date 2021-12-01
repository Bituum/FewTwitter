package com.example.twitt.service;

import com.example.twitt.entity.FileEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FileService {
    FileEntity storeFile(MultipartFile mpf) throws IOException;

    FileEntity getFile(int id);

    List<FileEntity> getAllFiles();
}
