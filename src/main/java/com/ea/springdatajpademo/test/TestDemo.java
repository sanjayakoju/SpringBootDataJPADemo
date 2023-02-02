package com.ea.springdatajpademo.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestDemo {

    @Autowired
    StudentService studentService;

    @GetMapping("/findAllApproved")
    public Object findAllApproved(
            @RequestParam(value = "search", required = false) String search,
            @RequestParam(defaultValue = "", required = false) int pageNo,
            @RequestParam(defaultValue = "", required = false) int pageSize
    ) {
//        return service.findAllApproved(pageNo,pageSize, search);
        return studentService.findAllApproved(PageRequest.of(pageNo, pageSize), search);
    }

}


