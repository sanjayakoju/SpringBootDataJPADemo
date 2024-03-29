package com.ea.springdatajpademo.runner;

import com.ea.springdatajpademo.model.Student;
import com.ea.springdatajpademo.persistence.StudentPersistence;
import com.ea.springdatajpademo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Pageable;
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
        studentRepository.save(new Student("Jack", 33));
        studentRepository.save(new Student("John", 20));
        studentRepository.save(new Student("Jill", 35));
        studentRepository.save(new Student("Jim", 30));
        studentRepository.save(new Student("Jasmin", 28));
        studentRepository.save(new Student("Jack", 33));
        studentRepository.save(new Student("John", 20));
        studentRepository.save(new Student("Jill", 35));
        studentRepository.save(new Student("Jim", 30));
        studentRepository.save(new Student("Jasmin", 28));
        studentRepository.save(new Student("Jack", 33));
        studentRepository.save(new Student("John", 23));
        studentRepository.save(new Student("Jill", 35));
        studentRepository.save(new Student("Jim", 30));
        studentRepository.save(new Student("Jasmin", 28));
        studentRepository.save(new Student("Jack", 33));
        studentRepository.save(new Student("John", 20));
        studentRepository.save(new Student("Jill", 35));
        studentRepository.save(new Student("Jim", 30));
        studentRepository.save(new Student("Jasmin", 28));
        studentRepository.save(new Student("Jack", 33));
        studentRepository.save(new Student("John", 21));
        studentRepository.save(new Student("Jill", 35));
        studentRepository.save(new Student("Jim", 30));
        studentRepository.save(new Student("Jasmin", 28));
        studentRepository.save(new Student("Jack", 33));
        studentRepository.save(new Student("John", 22));
        studentRepository.save(new Student("Jill", 35));
        studentRepository.save(new Student("Jim", 30));
        studentRepository.save(new Student("Jasmin", 28));

        List<Student> students = new ArrayList<>();

        System.out.println("\n Display All Data");
        students = studentRepository.findAll();
        for (Student student: students) {
            System.out.println(student);
        }

        System.out.println("\nFInd By Name");
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
        students = studentRepository.findAll(hasGpaGreaterThan(30));
//        Pageable pageable = Pageable.ofSize(10);
//        students = (List<Student>) studentRepository.findAll(hasGpaMoreThan(10), pageable);
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
