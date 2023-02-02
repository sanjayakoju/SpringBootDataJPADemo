package com.ea.springdatajpademo.test;

import com.ea.springdatajpademo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
//public interface ReceivedVoucherRepository extends JpaRepository<ReceivedVoucherMaster, Integer>, JpaSpecificationExecutor<ReceivedVoucherMaster> {
public interface ReceivedVoucherRepository extends JpaRepository<Student, Integer>, JpaSpecificationExecutor<Student> {

//    List<ReceivedVoucherMaster> findAllByStatusOrderByApprovedDateDesc(StatusEnum approved);
//    public List<ReceivedVoucherMaster> findByStatus(StatusEnum status);
//
//    @Query("select m from ReceivedVoucherMaster m where m.createdAt Between :dateFrom and :dateTo and status= :status")
//    public List<ReceivedVoucherMaster> findBetweenDates(String dateFrom, String dateTo, StatusEnum status);
//    public ReceivedVoucherMaster findByVoucherNumber(String voucherNumber);

}
