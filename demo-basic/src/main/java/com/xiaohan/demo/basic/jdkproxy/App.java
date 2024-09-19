package com.xiaohan.demo.basic.jdkproxy;

import java.lang.reflect.Proxy;

/**
 * 使用JDK 动态代理，实现Spring-AOP的通知: 每个Handler为一个切面
 */
public class App {

    public static void main(String[] args) {
        DemoServiceImpl demoService = new DemoServiceImpl();
        Class<? extends DemoServiceImpl> demoServiceClass = demoService.getClass();
        ClassLoader classLoader = demoServiceClass.getClassLoader();
        Class<?>[] interfaces = demoServiceClass.getInterfaces();

        DemoService beforeAspectService = (DemoService) Proxy.newProxyInstance(classLoader, interfaces, new BeforeInvocationHandler(demoService));
        beforeAspectService.doSomething("Before Proxy");

        DemoService aroundAspectService = (DemoService) Proxy.newProxyInstance(classLoader, interfaces, new AroundInvocationHandler(demoService));
        aroundAspectService.doSomething("Around Proxy");

    }
}
