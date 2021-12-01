package com.example.twitt.service;

import com.example.twitt.entity.FileEntity;
import com.example.twitt.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private FileRepository repository;

    @Override
    public FileEntity storeFile(MultipartFile mpf) throws IOException {
        String filename = StringUtils.cleanPath(mpf.getOriginalFilename());
        FileEntity newFile = new FileEntity(filename, mpf.getContentType(), mpf.getBytes());
        return repository.save(newFile);
    }

    @Override
    public FileEntity getFile(int id) {
        return repository.getById(id);
    }

    @Override
    public List<FileEntity> getAllFiles() {
        return repository.findAll();
    }
}
