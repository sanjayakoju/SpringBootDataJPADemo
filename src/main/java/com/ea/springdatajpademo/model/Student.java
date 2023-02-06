package com.ea.springdatajpademo.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@NamedQuery(name = "Student.findFailing", query = "SELECT s FROM Student s WHERE s.gpa < 30")
@NamedNativeQuery(name = "Student.findById", query = "SELECT * FROM Student WHERE id = ?1")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int gpa;

    public Student(String name, int gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGpa() {
        return gpa;
    }

    public void setGpa(int gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gpa=" + gpa +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && gpa == student.gpa && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, gpa);
    }
}
