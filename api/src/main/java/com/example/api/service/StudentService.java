package com.example.api.service;

import com.example.api.entity.Student;
import com.example.api.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    public Student addStudent(Student student){
        studentRepository.save(student);
        return student;
    }
    public Student getStudent(Long id){
        return studentRepository.getById(id);
    }
    public List<Student> get(String name){
        return studentRepository.getAllByUserName(name);
    }
}
