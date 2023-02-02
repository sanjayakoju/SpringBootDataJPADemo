package com.ea.springdatajpademo.specification;

import com.ea.springdatajpademo.model.Student;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class StudentSpecification {

    public static Specification<Student> hasGpaMoreThan(int gpa) {
        return new Specification<Student>() {
            @Override
            public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.greaterThan(root.get("gpa"), gpa);
            }
        };
    }

    public static Specification<Student> hasGpaGreaterThan(int gpa) {
        return (root, query, criteriaBuilder) ->
            criteriaBuilder.greaterThan(root.get("gpa"), gpa);
    }


    public Object findAllApproved(int pageNo, int pageSize, String search) {
        Page<ReceivedVoucherMaster> ReceivedVoucherMasterPage = repo.findAll((Specification<ReceivedVoucherMaster>) (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (search != null) {
                predicates.add(criteriaBuilder.or(criteriaBuilder.like(criteriaBuilder
                        .lower(root.get("date")), "%" + search + "%")));
            }
            query.distinct(true);
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }, PageRequest.of(pageNo, pageSize));

        List<ReceivedVoucherMaster> approvedList = repo.findAllByStatusOrderByApprovedDateDesc(StatusEnum.Approved);

        List<ReceivedVoucherMaster> sortedList = approvedList.stream().sorted(Comparator.comparing(ReceivedVoucherMaster::getVoucherNumber).reversed()).collect(Collectors.toList());
        return sortedList;

    }

}
