package com.ea.springdatajpademo.persistence;

import com.ea.springdatajpademo.model.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class StudentPersistence {

    @PersistenceContext
    private EntityManager em;

    public int insert(Student student) {
        em.persist(student);
        return student.getId();
    }
}
