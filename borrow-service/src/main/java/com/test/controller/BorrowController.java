package com.test.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.test.entity.Borrow;
import com.test.entity.UserBorrowDetail;
import com.test.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collections;

@RestController
public class BorrowController {

    @Resource
    BorrowService service;

    //@HystrixCommand(fallbackMethod = "onError")
    @RequestMapping("/borrow/{uid}")
     UserBorrowDetail findUserBorrows(@PathVariable("uid") int uid){
        return service.getUserBorrowDetailByUid(uid);
    }

    //备选返回方案
   // UserBorrowDetail onError(int uid){
     // return new UserBorrowDetail(null, Collections.emptyList());
   // }

}
