package com.example.twitt.controller;

import com.example.twitt.entity.UserExtension;
import com.example.twitt.service.UserExtensionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserExtController {
    @Autowired
    private UserExtensionServiceImpl userExtensionService;

    @GetMapping("/extension/{id}")
    public UserExtension getUserExtension(@RequestBody UserExtension ext, @PathVariable("id") int id) {
        return userExtensionService.getExt(id);
    }

    @PostMapping("/{uid}/extension")
    public void setExtensionForUser(@RequestBody UserExtension ext, @PathVariable("uid") int uid) {
        userExtensionService.setExt(ext, uid);
    }

    @GetMapping("/extension/all")
    public List<UserExtension> allExtensions(@RequestBody UserExtension ext) {
        return userExtensionService.getAll();
    }

    @PutMapping("/extension/")
    public UserExtension editUserExtensionByUserId(@RequestBody UserExtension ext) {
        return userExtensionService.editExt(ext);
    }

    @DeleteMapping("/extension/{id}")
    void deleteUserExtensionByUserId(@PathVariable("id") int id) {
        userExtensionService.deleteExt(id);
    }

}
