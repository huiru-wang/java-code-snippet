package com.xiaohan.demo.spring.aop.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
//@Order
public class ExecutionInterceptor implements Ordered {

    private static final int ORDER = 1;

    @Pointcut("execution(* com.xiaohan.demo.spring.aop.service.DemoService.doSomethingElse(..))")
    public void pointCut() {}

    @Before("pointCut()")
    public void before(JoinPoint joinPoint) {
        log.info("================== execution before {} ================", ORDER);
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("================== execution around start {} ================", ORDER);
        Object proceed = joinPoint.proceed();
        log.info("================== execution around end {} ================", ORDER);
        return proceed;
    }

    @AfterReturning(pointcut = "pointCut()", returning = "returnValue")
    public void doAfterReturning(JoinPoint joinPoint, Object returnValue) {
        log.info("=================== execution doAfterReturning start ===================");
        log.info("returnValue: {}", returnValue);
        log.info("=================== execution doAfterReturning done ====================");
    }

    @Override
    public int getOrder() {
        return ORDER;
    }
}
