package com.example.twitt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages =
        {
                "com.example.twitt.controller",
                "com.example.twitt.config",
                "com.example.twitt.entity",
                "com.example.twitt.repository",
                "com.example.twitt.service",
                "com.example.twitt.exception"
        })
public class TwittApplication {

    public static void main(String... args) {
        SpringApplication.run(TwittApplication.class, args);
    }

}
