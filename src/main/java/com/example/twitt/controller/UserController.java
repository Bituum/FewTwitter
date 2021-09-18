package com.example.twitt.controller;

import com.example.twitt.entity.MainUser;
import com.example.twitt.exception.UsernameIsTakenException;
import com.example.twitt.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class UserController {
    @Autowired
    private final UserServiceImpl userService;

    private static Logger logger = Logger.getLogger(UserController.class.getName());
    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }


    @GetMapping("/user")
    List<MainUser> all() {
        List<MainUser> users = userService.getAll();
        for(MainUser us : users){
            logger.info(us.getLogin());
            logger.info(us.getPassword());
        }
        return userService.getAll();
    }


    @PostMapping("/user")
    MainUser newUser(@RequestBody MainUser newUser) {
        try {
            MainUser user = userService.addOne(newUser);
            return userService.addOne(user);
        } catch (UsernameIsTakenException usernameIsTakenException) {
            usernameIsTakenException.getMessage();
        }
        return null;
    }


    @GetMapping("/user/{id}")
    MainUser one(@PathVariable int id) {
        return userService.getOneById(id);
    }

    @PutMapping("/user/{id}")
    MainUser replaceUser(@RequestBody MainUser user) {
        return userService.updateOne(user);
    }

    @DeleteMapping("/user/{id}")
    void deleteUser(@PathVariable int id) {
        userService.deleteOneById(id);
    }

}
