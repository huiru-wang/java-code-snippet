package com.xiaohan.demo.spring.aop;

import com.xiaohan.demo.spring.aop.service.DemoService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class OperationLogTest {

    @Resource
    private DemoService demoService;

    @Test
    public void testForMethodInterceptor() {
        demoService.doSomeOperation();
    }
}
