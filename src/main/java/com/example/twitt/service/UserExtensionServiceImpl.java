package com.example.twitt.service;


import com.example.twitt.entity.MainUser;
import com.example.twitt.entity.UserExtension;
import com.example.twitt.repository.UserExtensionRepository;
import com.example.twitt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserExtensionServiceImpl implements UserExtensionService {
    @Autowired
    private UserExtensionRepository userExtensionRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserExtension getExt(int id) {
        return userExtensionRepository.findById(id)
                .orElseThrow(
                        () -> new IllegalArgumentException("NOT FOUND")
                );
    }

    @Override
    public void setExt(UserExtension extension, int uid) {
        Optional<MainUser> user = userRepository.findById(uid);
        extension.setId(uid);

        user.ifPresent(usr -> usr.setExtension(extension));

        extension.setUser(user.get());
        userRepository.save(user.get());
    }

    @Override
    public void deleteExt(int id) {
        userExtensionRepository.deleteById(id);
    }

    @Override
    public UserExtension editExt(UserExtension ext) {
        return userExtensionRepository.save(ext);
    }

    @Override
    public List<UserExtension> getAll() {
        return userExtensionRepository.findAll();
    }
}
