package com.example.api.student;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    public List<Student> print(){
        return List.of(new Student(1L,"Yusuf",35),
                new Student(2L,"Kadir",20));
    }
}
