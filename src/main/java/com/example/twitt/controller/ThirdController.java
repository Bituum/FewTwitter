package com.example.twitt.controller;

import com.example.twitt.entity.TestEntity;
import com.example.twitt.repository.TestRepository;
import com.example.twitt.service.TestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ThirdController {

    @Autowired
    private TestServiceImpl service;

    @Autowired
    private TestRepository repository;

    @GetMapping("/test")
    public List<TestEntity> all() {
        return service.getAll();
    }

    @PostMapping("/test")
    public TestEntity newEntity(@RequestBody TestEntity entity) {
        return service.updateOrSave(entity);
    }

    @GetMapping("/test/{id}")
    public TestEntity getOne(@PathVariable int id) {
        return service.getOne(id);
    }

    @PutMapping("/test/{id}")
    public TestEntity updateEntity(@RequestBody TestEntity entity, @PathVariable int id) {
        //TODO
    }

    @DeleteMapping("/test/{id}")
    public void deleteEntity(@PathVariable int id) {
        service.delete(id);
    }


}
