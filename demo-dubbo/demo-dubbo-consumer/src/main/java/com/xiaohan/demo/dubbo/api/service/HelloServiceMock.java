package com.xiaohan.demo.dubbo.api.service;

import com.xiaohan.demo.dubbo.api.model.HelloRequest;
import com.xiaohan.demo.dubbo.api.model.HelloResponse;
import com.xiaohan.demo.dubbo.api.model.ServiceResult;
import org.springframework.stereotype.Component;

/**
 * 需要在service同目录下实现一个Mock方法，dubbo通过类名识别：[serviceName + Mock]
 */
@Component
public class HelloServiceMock implements HelloService {

    @Override
    public ServiceResult<HelloResponse> sayHello(HelloRequest helloRequest) {
        String source = helloRequest.getSource();
        String message = helloRequest.getMessage();
        HelloResponse response = new HelloResponse();
        response.setSource(source);
        response.setMessage("response from [Mock], got message: [ " + message + " ]");
        return ServiceResult.success(response);
    }
}
