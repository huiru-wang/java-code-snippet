package com.xiaohan.demo.spring.sentinel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动时，指定JVM参数，接入sentinel控制台：
 * `-Dcsp.sentinel.dashboard.server=127.0.0.1:8858`
 * 指定sentinel监控的当前应用的端口
 * `-Dcsp.sentinel.api.port=8080`
 */
@SpringBootApplication
public class DemoSpringSentinel {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringSentinel.class, args);
    }
}
