package com.xiaohan.demo.spring.aop.interceptor;

import com.xiaohan.demo.spring.aop.annotation.OperationLog;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

@Slf4j
@Component("operationLogInterceptor")
public class OperationLogInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        OperationLog annotation = getAnnotation(methodInvocation);
        String operator = annotation.operator();
        Object proceed = methodInvocation.proceed();

        log.info("operator:[{}] do:[{}]", operator, proceed.toString());
        return methodInvocation.proceed();
    }

    public OperationLog getAnnotation(MethodInvocation methodInvocation) {
        return AnnotationUtils.getAnnotation(methodInvocation.getMethod(), OperationLog.class);
    }
}
