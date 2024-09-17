package com.xiaohan.demo.dubbo.service;

import com.xiaohan.demo.dubbo.api.model.ServiceResult;
import com.xiaohan.demo.dubbo.api.service.DemoService;

public class DemoServiceImpl implements DemoService {

    @Override
    public ServiceResult<String> sayHello(String name) {
        String response = String.format("%s : %s", "demo-dubbo-native", name);
        return ServiceResult.success(response);
    }
}
