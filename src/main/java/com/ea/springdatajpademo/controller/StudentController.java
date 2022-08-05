package com.ea.springdatajpademo.controller;

import com.ea.springdatajpademo.model.Student;
import com.ea.springdatajpademo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/students/{student_id}")
    public Student getPassedStudent(@PathVariable(name = "student_id") int id) {
        return studentRepository.findById(id);
    }

    @GetMapping("/allStudents")
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

}
