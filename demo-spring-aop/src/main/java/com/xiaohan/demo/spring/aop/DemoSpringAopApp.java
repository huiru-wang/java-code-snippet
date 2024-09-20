package com.xiaohan.demo.spring.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;

@ImportResource("classpath:applicationContext.xml")
@EnableAspectJAutoProxy
@SpringBootApplication
public class DemoSpringAopApp {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringAopApp.class, args);
    }
}
