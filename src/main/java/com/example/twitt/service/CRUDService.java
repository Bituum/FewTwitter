package com.example.twitt.service;

import com.example.twitt.entity.MainUser;

import java.util.List;

public interface CRUDService<T> {
    T addOne(T object);
    void deleteOneById(int id);
    void deleteOne(T object);
    List<T> getAll();
    T getOneById(int id);
}
