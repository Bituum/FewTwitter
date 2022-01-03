package com.example.twitt.controller.admin;

import com.example.twitt.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
    @Autowired
    private UserServiceImpl service;


    @GetMapping("/admin/get")
    public ResponseEntity adminResponse() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
    }
}
