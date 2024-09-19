package com.xiaohan.demo.spring.aop.interceptor;

import com.xiaohan.demo.spring.aop.annotation.AopLifeCycle;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.junit.jupiter.api.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Slf4j
@Component
@Aspect
public class LifeCycleInterceptor {

    private static final int ORDER = 2;

    @Pointcut("@annotation(com.xiaohan.demo.spring.aop.annotation.AopLifeCycle)")
    public void pointCut() {}

    @Before("pointCut()")
    @Order(ORDER)
    public void before(JoinPoint joinPoint) {
        log.info("====================== before start ======================", ORDER);

        Object target = joinPoint.getTarget();
        String kind = joinPoint.getKind();

        Signature signature = joinPoint.getSignature();
        String methodName = signature.getName();

        Object[] args = joinPoint.getArgs();
        log.info("target: [{}], kind: [{}], methodName: [{}], args: [{}]", target, kind, methodName, args);

        try {
            // 获取注解参数
            Class[] parameterTypes = ((MethodSignature) signature).getParameterTypes();
            Method declaredMethod = target.getClass().getDeclaredMethod(methodName, parameterTypes);
            AopLifeCycle annotation = declaredMethod.getAnnotation(AopLifeCycle.class);
            String value = annotation.value();
            log.info("annotation value: [{}]", value);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        log.info("====================== before done ========================");
    }


    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("======================= around start =======================");


        Object methodResult = joinPoint.proceed();
        log.info("execution method, result: [{}]", methodResult);

        log.info("======================= around done =======================");
        return methodResult;
    }

    @After("pointCut()")
    public void after(JoinPoint joinPoint) {
        log.info("======================= after =======================");
    }

    @AfterReturning(pointcut = "pointCut()", returning = "returnValue")
    public void doAfterReturning(JoinPoint joinPoint, Object returnValue) {
        log.info("=================== doAfterReturning start ===================");
        log.info("returnValue: {}", returnValue);
        log.info("====================doAfterReturning done =============");
    }

    @AfterThrowing(pointcut = "pointCut()", throwing = "throwingException")
    public void doAfterThrowing(JoinPoint joinPoint, Throwable throwingException) {
        log.info("=================== doAfterThrowing ===================");
    }
}
