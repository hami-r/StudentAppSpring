package com.nest.studentappnew_backend.controller;


import com.nest.studentappnew_backend.dao.StudentDao;
import com.nest.studentappnew_backend.model.StudentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentDao dao;

    @GetMapping("/")
    public String homepage(){
        return "Welcome to the website";
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
    public HashMap<String, String> addStudent(@RequestBody StudentModel s){
        System.out.println(s.getName().toString());
        dao.save(s);
        HashMap<String ,String > map = new HashMap<>();
        map.put("status","success");
        return map;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/view")
    public List<StudentModel> view(){
        return (List<StudentModel>) dao.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/search",consumes = "application/json", produces = "application/json")
    public List<StudentModel> search(@RequestBody StudentModel s) {
        return (List<StudentModel>) dao.searchStudent(s.getAdmno());
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/delete",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> delete(@RequestBody StudentModel s)
    {
        String id=String.valueOf(s.getId());
        System.out.println(id);
        dao.deleteStudent(s.getId());
        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");
        return map;
    }


}
