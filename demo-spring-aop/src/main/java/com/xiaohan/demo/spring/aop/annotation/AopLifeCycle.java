package com.xiaohan.demo.spring.aop.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AopLifeCycle {

    /**
     * 权限点
     */
    String value() default "";
}
