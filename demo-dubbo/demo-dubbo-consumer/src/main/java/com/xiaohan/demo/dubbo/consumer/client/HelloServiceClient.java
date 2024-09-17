package com.xiaohan.demo.dubbo.consumer.client;

import com.xiaohan.demo.dubbo.api.model.HelloRequest;
import com.xiaohan.demo.dubbo.api.model.HelloResponse;
import com.xiaohan.demo.dubbo.api.model.ServiceResult;
import com.xiaohan.demo.dubbo.api.service.HelloService;
import org.apache.dubbo.common.constants.LoadbalanceRules;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Component;

@Component
public class HelloServiceClient {

    @DubboReference(
            check = false,              // 启动时检查是否有服务提供，没有则启动失败
            version = "1.0.0",          // 服务version
            timeout = 5000,             // 客户端timeout
            retries = 1,                // 重试次数default 1
            loadbalance = LoadbalanceRules.SHORTEST_RESPONSE,   // 负载均衡策略，默认为random
            mock = "true"               // 服务降级触发调用 HelloServiceMock
    )
    private HelloService helloService;

    public HelloResponse sayHello(String source, String message) {
        HelloRequest helloRequest = new HelloRequest();
        helloRequest.setSource(source);
        helloRequest.setMessage(message);

        ServiceResult<HelloResponse> helloResponseResult = helloService.sayHello(helloRequest);
        if (null == helloResponseResult || !helloResponseResult.isSuccess()) {
            throw new RuntimeException("sayHello fail");
        }
        return helloResponseResult.getData();
    }
}
