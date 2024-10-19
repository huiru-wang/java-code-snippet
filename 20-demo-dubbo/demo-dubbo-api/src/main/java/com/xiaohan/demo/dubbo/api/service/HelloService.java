package com.xiaohan.demo.dubbo.api.service;

import com.xiaohan.demo.dubbo.api.model.HelloRequest;
import com.xiaohan.demo.dubbo.api.model.HelloResponse;
import com.xiaohan.demo.dubbo.api.model.ServiceResult;

public interface HelloService {

    ServiceResult<HelloResponse> sayHello(HelloRequest helloRequest);
}
