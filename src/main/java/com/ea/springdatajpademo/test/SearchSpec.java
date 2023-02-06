package com.ea.springdatajpademo.test;

import com.ea.springdatajpademo.model.Student;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class SearchSpec implements Specification<Student> {

    private static final String FILTER_BY_NAME = "name";
    private final String property;
    private final String value;

    public SearchSpec(String property, String value) {
        this.property = property;
        this.value = value;
    }

    @Override
    public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> criteriaQuery,
                                 CriteriaBuilder criteriaBuilder) {
        switch (property) {
            case FILTER_BY_NAME:
                return criteriaBuilder.like(root.get(property), value + "%");
            default:
                return null;
        }
    }
}
