package com.ea.springdatajpademo.controller;

import com.ea.springdatajpademo.model.Student;
import com.ea.springdatajpademo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/students")
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @PostMapping("/students")
    public void save(@RequestBody Student student) {
        studentRepository.save(student);
    }

}
