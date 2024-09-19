package com.xiaohan.demo.spring.aop;

import com.xiaohan.demo.spring.aop.service.DemoService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class AopLifecycleDemoTest {

    @Resource
    private DemoService demoService;

    /**
     * 测试同一个切面下的不同通知的执行顺序:
     * <pre>
     * 1. =============== around 开始 ===============
     * 2. before 开始
     * 3. before 结束
     * 4. doAfterReturning  开始
     * 5. doAfterReturning  结束
     * 6. after 开始
     * 7. after 结束
     * 8. =============== around 结束 ===============
     * </pre>
     */
    @Test
    public void testForAopLifeCycle() {
        demoService.doSomething();
    }

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
