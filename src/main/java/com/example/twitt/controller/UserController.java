package com.example.twitt.controller;

import com.example.twitt.entity.MainUser;
import com.example.twitt.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/user")
    List<MainUser> all() {
        return userService.getAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/user")
    MainUser newEmployee(@RequestBody MainUser newEmployee) {
        return userService.addOne(newEmployee);
    }

    // Single item

    @GetMapping("/user/{id}")
    MainUser one(@PathVariable int id) {
        return userService.getOneById(id);
    }

    @PutMapping("/user/{id}")
    MainUser replaceEmployee(@RequestBody MainUser newEmployee) {

        return userService.addOne(newEmployee);
    }

    @DeleteMapping("/user/{id}")
    void deleteEmployee(@PathVariable int id) {
        userService.deleteOneById(id);
    }

}
