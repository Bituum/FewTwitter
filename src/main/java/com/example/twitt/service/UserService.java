package com.example.twitt.service;

import com.example.twitt.entity.MainUser;


import java.util.List;

public interface UserService {
    MainUser addOne(MainUser object);
    void deleteOneById(int id);
    void deleteOne(MainUser object);
    List<MainUser> getAll();
    MainUser getOneById(int id);
}
