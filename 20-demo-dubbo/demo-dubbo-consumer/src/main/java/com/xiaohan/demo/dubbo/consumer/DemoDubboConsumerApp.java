package com.xiaohan.demo.dubbo.consumer;

import com.xiaohan.demo.dubbo.api.model.HelloResponse;
import com.xiaohan.demo.dubbo.consumer.client.HelloServiceClient;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@Slf4j
@EnableDubbo
@SpringBootApplication
public class DemoDubboConsumerApp {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DemoDubboConsumerApp.class, args);
        HelloServiceClient serviceClient = context.getBean(HelloServiceClient.class);
        HelloResponse response = serviceClient.sayHello("DemoDubboConsumerApp", "test");
        log.info("response message: {}", response.getMessage());
    }
}
