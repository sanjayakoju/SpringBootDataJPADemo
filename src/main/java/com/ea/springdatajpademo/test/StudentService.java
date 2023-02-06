package com.ea.springdatajpademo.test;

import com.ea.springdatajpademo.model.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class StudentService {

    @Autowired
    ReceivedVoucherRepository receivedVoucherRepository;

    // public Object findAllApproved(int pageNo, int pageSize, String search) {
    public Page<Student> findAllApproved(PageRequest pageRequest, Object search) {

//        Page<ReceivedVoucherMaster> ReceivedVoucherMasterPage = repo.findAll((Specification<ReceivedVoucherMaster>) (root, query, criteriaBuilder) -> {
//            List<Predicate> predicates = new ArrayList<>();
//            if (search != null) {
//                predicates.add(criteriaBuilder.or(criteriaBuilder.like(criteriaBuilder
//                        .lower(root.get("date")), "%" + search + "%")));
//            }
//            query.distinct(true);
//            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
//        }, PageRequest.of(pageNo, pageSize));
//
//        List<ReceivedVoucherMaster> approvedList = repo.findAllByStatusOrderByApprovedDateDesc(StatusEnum.Approved);
//
//        List<ReceivedVoucherMaster> sortedList = approvedList.stream().sorted(Comparator.comparing(ReceivedVoucherMaster::getVoucherNumber).reversed()).collect(Collectors.toList());
//        return sortedList;

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, String> map = objectMapper.convertValue(search, Map.class);
        final SearchSpecificationBuilder builder = new SearchSpecificationBuilder(map);
        final Specification<Student> specification = builder.build();
        return receivedVoucherRepository.findAll(specification, pageRequest);

//        return receivedVoucherRepository.findAll(searchSpec(search), pageRequest);
//      return repo.findAllByStatusOrderByApprovedDateDesc(StatusEnum.Approved, searchSpec(search), pageRequest);
    }
}
