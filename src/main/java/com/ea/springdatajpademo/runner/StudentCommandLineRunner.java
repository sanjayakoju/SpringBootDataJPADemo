package com.ea.springdatajpademo.runner;

import com.ea.springdatajpademo.model.Student;
import com.ea.springdatajpademo.persistence.StudentPersistence;
import com.ea.springdatajpademo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.ea.springdatajpademo.specification.StudentSpecification.hasGpaGreaterThan;
import static com.ea.springdatajpademo.specification.StudentSpecification.hasGpaMoreThan;

@Component
public class StudentCommandLineRunner implements CommandLineRunner {

    @Autowired
    private StudentPersistence studentPersistence;
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {
//        usingEnitityManager();

        usingSpringDataJPA();
    }

    private void usingSpringDataJPA() {
//        studentRepository.save(new Student("Jack", 33));
//        studentRepository.save(new Student("John", 20));
//        studentRepository.save(new Student("Jill", 35));
//        studentRepository.save(new Student("Jim", 30));
//        studentRepository.save(new Student("Jasmin", 28));

        List<Student> students = new ArrayList<>();

        students = studentRepository.findByName("Jack");
        for (Student student: students) {
            System.out.println(student);
        }

        System.out.println("\nPassing Student Using Dynamic Query");
        students = studentRepository.findStudentsThatPassed(30);
        for (Student student: students) {
            System.out.println(student);
        }

        System.out.println("\nCalling Name Query Failed Student");
        students = studentRepository.findFailing();
        for (Student student: students) {
            System.out.println(student);
        }

        System.out.println("\nPassing Student Using Native Query");
        students = studentRepository.findStudentsThatPassedNative(30);
        for (Student student: students) {
            System.out.println(student);
        }

        System.out.println("\nNamed Native Query Call find by Id");
        Student student = studentRepository.findById(1);
        System.out.println(student);

        System.out.println("\nPassing Student Using Specification GPA More Than");
        students = studentRepository.findAll(hasGpaMoreThan(30));
        for (Student std: students) {
            System.out.println(std);
        }

        System.out.println("\nPassing Student Using Specification GPA Greater Than");
        students = studentRepository.findAll(hasGpaGreaterThan(10));
        for (Student std: students) {
            System.out.println(std);
        }
    }

    private void usingEnitityManager() {
        studentPersistence.insert(new Student("Jack", 33));
        studentPersistence.insert(new Student("John", 20));
        studentPersistence.insert(new Student("Jill", 35));
        studentPersistence.insert(new Student("Jim", 30));
        studentPersistence.insert(new Student("Jasmin", 28));
    }
}
