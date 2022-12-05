package com.nest.studentappnew_backend.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping("/")
    public String homepage(){
        return "Welcome to the website";
    }

    @GetMapping("/contact")
    public String contact(){
        return "contact page";
    }

    @GetMapping("/gallery")
    public String gallery() {
        return "gallery page";
    }
}
