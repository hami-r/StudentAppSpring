package com.nest.studentappnew_backend.controller;


import com.nest.studentappnew_backend.model.StudentModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping("/")
    public String homepage(){
        return "Welcome to the website";
    }

    @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
    public String addStudent(@RequestBody StudentModel s){
        System.out.println(s.getName().toString());
        return "student added successfully";
    }

    @GetMapping("/view")
    public String view(){
        return "view page";
    }


}
