package com.example.twitt.service;

import com.example.twitt.entity.TestEntity;

import java.util.List;

public interface TestService {
    TestEntity getOne(int key);
    List<TestEntity> getAll();
    void delete(int key);
    TestEntity updateOrSave(TestEntity entity);
}
