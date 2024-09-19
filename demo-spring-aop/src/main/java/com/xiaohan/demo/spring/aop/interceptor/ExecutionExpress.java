package com.xiaohan.demo.spring.aop.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class ExecutionExpress {

    /**
     * <pre>
     * 表达式：
     * execution(modifiers-pattern? ret-type-pattern declaring-type-pattern? name-pattern(param-pattern) throws-pattern?)
     * execution(方法修饰符? 方法返回类型 类的全限定名 方法名 (方法参数))
     * </pre>
     */

    @Pointcut("execution(* com.xiaohan.demo.spring.aop.service.*.*(..))")
    public void pointCut() {}

    // 拦截包路径下的所有public方法
    @Pointcut("execution(public * com.xiaohan.demo.spring.aop.service.*.*(..))")
    public void pointCut1() {}

    // 指定目标类下的所有方法
    @Pointcut("execution(* com.xiaohan.demo.spring.aop.service.DemoService.*(..))")
    public void pointCut2() {}

    // 指定目标类下的save开头的方法
    @Pointcut("execution(* com.xiaohan.demo.spring.aop.service.DemoService.save*(..))")
    public void pointCut3() {}

    // 指定目标类下的所有save开头方法，且第一个入参为String类型
    @Pointcut("execution(* com.xiaohan.demo.spring.aop.service.DemoService.save*(String,..))")
    public void pointCut4() {}
}
