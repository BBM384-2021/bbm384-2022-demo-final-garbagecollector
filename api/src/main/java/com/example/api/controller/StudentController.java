package com.example.api.controller;

import com.example.api.entity.Student;
import com.example.api.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping(path = "baban")
    public Student addNewStudent(@RequestBody Student student){

        return studentService.addStudent(student);
    }

    @GetMapping(path = "/{id}")
    public Student getStudent(@PathVariable("id") Long id){
        return  studentService.getStudent(id);

    }
    @GetMapping(path = "/get/{name}")
    public List<Student> get(@PathVariable("name") String name){
        return studentService.get(name);
    }
}
