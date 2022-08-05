package com.ea.springdatajpademo.repository;

import com.ea.springdatajpademo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    public List<Student> findByName(String name);

    /**
     * JPQL (Dynamic Query With Type)
     */
    @Query("SELECT s FROM Student s WHERE s.gpa >= ?1")
    public List<Student> findStudentsThatPassed(int passingGpa);

    /**
     * Calling Named Query From Entity
     */
    public List<Student> findFailing();

    /**
     * Calling Native Query
     */
    @Query(value = "SELECT * FROM Student WHERE gpa >= ?1", nativeQuery = true)
    List<Student> findStudentsThatPassedNative(int gpa);

    Student findById(int id);
}
