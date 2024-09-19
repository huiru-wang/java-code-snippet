package com.xiaohan.demo.basic.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class AroundInvocationHandler implements InvocationHandler {

    private final Object target;

    public AroundInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 代理前置增强
        System.out.println("=============== around start ===============");

        // 执行原方法
        Object invoke = method.invoke(target, args);

        // 后置增强
        System.out.println("=============== around end ===============");
        return invoke;
    }
}
