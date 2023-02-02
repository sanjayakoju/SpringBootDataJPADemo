package test;

import com.ea.springdatajpademo.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import static test.TestDemo.SearchSpecification.searchSpec;

public class TestDemo {

    @GetMapping("/findAllApproved")
    public Object findAllApproved(
            @RequestParam(value = "search", required = false) String search,
            @RequestParam(defaultValue = "", required = false) int pageNo,
            @RequestParam(defaultValue = "", required = false) int pageSize
    ) {
//        return service.findAllApproved(pageNo,pageSize, search);
        return findAllApproved(PageRequest.of(pageNo, pageSize), search);
    }


    @Override
//    public Object findAllApproved(int pageNo, int pageSize, String search) {
    public static Page<Object> findAllApproved(PageRequest pageRequest, String search) {
        return repo.findAll(searchSpec(search), pageRequest);
        return repo.findAllByStatusOrderByApprovedDateDesc(StatusEnum.Approved, searchSpec(search), pageRequest);

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

    }

    public interface ReceivedVoucherRepository extends JpaRepository<ReceivedVoucherMaster, Integer>, JpaSpecificationExecutor<ReceivedVoucherMaster> {

        List<ReceivedVoucherMaster> findAllByStatusOrderByApprovedDateDesc(StatusEnum approved);
        public List<ReceivedVoucherMaster> findByStatus(StatusEnum status);

        @Query("select m from ReceivedVoucherMaster m where m.createdAt Between :dateFrom and :dateTo and status= :status")
        public List<ReceivedVoucherMaster> findBetweenDates(String dateFrom, String dateTo, StatusEnum status);
        public ReceivedVoucherMaster findByVoucherNumber(String voucherNumber);

    }

    public class SearchSpecification {
        public static  Specification<Student> searchSpec(String s) {
            return new Specification<Student>() {
                @Override
                public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                    return criteriaBuilder.like(root.get("date"), s);
                }
            };
        }
    }
}

