package com.xiaohan.demo.basic.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class BeforeInvocationHandler implements InvocationHandler {

    private final Object target;

    public BeforeInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 代理前置增强
        System.out.println("=============== before ===============");
        // 执行原方法
        return method.invoke(target, args);
    }
}
