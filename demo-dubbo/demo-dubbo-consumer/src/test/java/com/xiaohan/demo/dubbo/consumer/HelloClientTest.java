package com.xiaohan.demo.dubbo.consumer;

import com.xiaohan.demo.dubbo.api.model.HelloResponse;
import com.xiaohan.demo.dubbo.consumer.client.HelloServiceClient;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@Slf4j
@SpringBootTest
public class HelloClientTest {

    @Resource
    private HelloServiceClient helloServiceClient;

    @Test
    public void testHelloClient() {
        HelloResponse response = helloServiceClient.sayHello("testHelloClient", "test");
        log.info("response: {}", response);
    }
}
