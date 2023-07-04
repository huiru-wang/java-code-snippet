package com.snippet.springtransaction.Controller;

import com.snippet.springtransaction.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by whr on 2023-05-26
 */
@Slf4j
@RestController
@RequestMapping("/api/user/tx")
public class TxController {

    @Autowired
    UserService userService;

    // 共用事务，任何方法抛出异常，被Transaction感知，则全部回滚
    @GetMapping("/REQUIRED")
    public void txAnnotation1() {
        userService.updateUserAndOrder1();
    }

    // 创建新的事务, 子事务的异常不会影响父事务
    @GetMapping("/REQUIRES_NEW")
    public void txAnnotation2() {
        userService.updateUserAndOrder2();
    }

    // 父事务回滚，子事务一起回滚
    // 子事务回滚，父事务不受影响，前提：子事务的异常不能影响到父事务，父事务将异常处理掉不要抛出去
    @GetMapping("/NESTED")
    public void txAnnotation3() {
        userService.updateUserAndOrder3();
    }

    @GetMapping("/MANDATORY")
    public void txAnnotation4() {
        userService.updateUserAndOrder4();
    }

    @GetMapping("/SUPPORTS")
    public void txAnnotation5() {
        userService.updateUserAndOrder5();
    }

    @GetMapping("/SUPPORTED")
    public void txAnnotation6() {
        userService.updateUserAndOrder6();
    }

    @GetMapping("/NEVER")
    public void txAnnotation7() {
        userService.updateUserAndOrder7();
    }

    @GetMapping("/READONLY")
    public void txAnnotation8() {
        userService.updateUserAndOrder8();
    }
}
