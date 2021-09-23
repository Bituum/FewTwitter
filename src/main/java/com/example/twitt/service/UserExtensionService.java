package com.example.twitt.service;


import com.example.twitt.entity.UserExtension;

import java.util.List;

public interface UserExtensionService {
    UserExtension getExt(int id);

    void setExt(UserExtension extension, int uid);

    void deleteExt(int id);

    UserExtension editExt(UserExtension ext);

    List<UserExtension> getAll();
}
