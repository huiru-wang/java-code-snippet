package com.xiaohan.demo.spring.aop.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.assertj.core.condition.Join;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
//@Order
public class AnnotationInterceptor implements Ordered {

    private static final int ORDER = 13;

    @Pointcut("@annotation(com.xiaohan.demo.spring.aop.annotation.OrderDemoTest)")
    public void pointCut() {}

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("================== annotation around start {} ================", ORDER);
        Object proceed = joinPoint.proceed();

        log.info("================== annotation around end {} ================", ORDER);
        return proceed;
    }

    @Before("pointCut()")
    public void before(JoinPoint joinpoint) {
        log.info("================== annotation before {} ================", ORDER);
    }

    @AfterReturning(pointcut = "pointCut()", returning = "returnValue")
    public void doAfterReturning(JoinPoint joinPoint, Object returnValue) {
        log.info("=================== annotation doAfterReturning start ===================");
        log.info("returnValue: {}", returnValue);
        log.info("=================== annotation doAfterReturning done ====================");
    }

    @Override
    public int getOrder() {
        return ORDER;
    }
}
