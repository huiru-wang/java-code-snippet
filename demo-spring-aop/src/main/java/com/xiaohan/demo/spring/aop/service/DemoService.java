package com.xiaohan.demo.spring.aop.service;

import com.xiaohan.demo.spring.aop.annotation.AopLifeCycle;
import com.xiaohan.demo.spring.aop.annotation.OperationLog;
import com.xiaohan.demo.spring.aop.annotation.OrderDemoTest;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

    @AopLifeCycle(value = "annotation value test")
    public String doSomething() {
        return "do something";
    }

    @OrderDemoTest
    public String doSomethingElse() {
        return "do something else";
    }

    @OperationLog(operator = "test")
    public String doSomeOperation() {
        return "do something operation";
    }
}
