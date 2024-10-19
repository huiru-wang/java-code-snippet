package com.xiaohan.demo.dubbo.provider;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo(scanBasePackages = "com.xiaohan.demo.dubbo.provider.service")
@SpringBootApplication
public class DemoDubboProviderApp {

    public static void main(String[] args) {
        SpringApplication.run(DemoDubboProviderApp.class, args);
    }
}
