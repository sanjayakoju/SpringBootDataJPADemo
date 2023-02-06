package com.ea.springdatajpademo.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestDemo {

    @Autowired
    StudentService studentService;

    @PostMapping("/findAllApproved")
    public Object findAllApproved(
            @RequestBody Object search,
            @RequestParam(defaultValue = "", required = false) int pageNo,
            @RequestParam(defaultValue = "", required = false) int pageSize
    ) {
//        return service.findAllApproved(pageNo,pageSize, search);
        return studentService.findAllApproved(PageRequest.of(pageNo, pageSize), search);
    }

}


