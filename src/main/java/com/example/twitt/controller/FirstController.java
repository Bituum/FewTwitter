package com.example.twitt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class FirstController {
    @GetMapping("/hello")
    public String hello(Model model){
        model.addAttribute("hello", "Hello!Nice Dick");
        return "hello";
    }

    @GetMapping("/second")
    public String second(){
        return "hello";
    }

}
