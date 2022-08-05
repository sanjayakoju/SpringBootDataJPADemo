package com.ea.springdatajpademo.model;

import javax.persistence.*;

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
}
