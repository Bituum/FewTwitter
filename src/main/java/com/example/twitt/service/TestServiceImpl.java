package com.example.twitt.service;

import com.example.twitt.entity.TestEntity;
import com.example.twitt.repository.TestRepository;
import com.example.twitt.util.TestNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class TestServiceImpl implements TestService{
    @Autowired
    private TestRepository repository;

    @Override
    public TestEntity getOne(int key) {
        return repository.findById(key).orElseThrow(
                () -> new TestNotFoundException(key)
        );
    }

    @Override
    public List<TestEntity> getAll() {
        return repository.findAll();
    }

    @Override
    public TestEntity updateOrSave(TestEntity entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(int key) {
        repository.deleteById(key);
    }


}
