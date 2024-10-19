package com.xiaohan.demo.dubbo.api.service;

import com.xiaohan.demo.dubbo.api.model.ServiceResult;

public interface DemoService {

    ServiceResult<String> sayHello(String name);
}
