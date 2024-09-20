package com.xiaohan.demo.spring.aop;

import com.xiaohan.demo.spring.aop.service.DemoService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class AspectOrderTest {

    @Resource
    private DemoService demoService;

    /**
     * 测试不同切面执行优先级
     * <pre>
     * 针对切面：
     * 1. 实现接口：{@link org.springframework.core.Ordered}
     * 2. 使用注解：{@link org.springframework.core.annotation.Order}
     * </pre>
     */
    @Test
    public void testForAopOrders() {
        demoService.doSomethingElse();
    }
}
