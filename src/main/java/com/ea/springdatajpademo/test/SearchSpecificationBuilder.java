package com.ea.springdatajpademo.test;

import com.ea.springdatajpademo.model.Student;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SearchSpecificationBuilder {

    private final Map<String, String> params;

    public SearchSpecificationBuilder(Map<String, String> params) {
        this.params = params;
    }

    public Specification<Student> build() {
        if (params.isEmpty()) {
            return null;
        }

        final List<String> properties = new ArrayList<>(params.keySet());

        final String firstProperty = properties.get(0);

        Specification<Student> spec = new SearchSpec(properties.get(0),
                params.get(firstProperty));

        for (int i = 1; i < properties.size(); i++) {
            final String property = properties.get(i);
            spec = Specification.where(spec)
                    .and(new SearchSpec(property, params.get(property)));
        }

        return spec;
    }


    //    public static Specification<Student> searchSpec(String searchKey) {
//        return new Specification<Student>() {
//            @Override
//            public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
////                return criteriaBuilder.greaterThan(root.get("gpa"), searchKey);
//                return criteriaBuilder.like(root.get("name"), "%" + searchKey + "%");
//            }
//        };
//    }


}