package com.xiaohan.demo.dubbo;

import com.xiaohan.demo.dubbo.api.service.DemoService;
import com.xiaohan.demo.dubbo.service.DemoServiceImpl;
import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.config.ProtocolConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfig;
import org.apache.dubbo.config.bootstrap.DubboBootstrap;
import org.apache.dubbo.config.bootstrap.builders.ServiceBuilder;

/**
 * <a href="https://cn.dubbo.apache.org/zh-cn/overview/mannual/java-sdk/tasks/develop/api/">Dubbo-native Doc</a>
 */
public class DemoDubboNativeApp {

    public static void main(String[] args) {
        String applicationName = "demo-dubbo-native-app";
        ProtocolConfig protocolConfig = new ProtocolConfig(CommonConstants.TRIPLE, 50051);
        protocolConfig.setSerialization("protobuf");
        RegistryConfig registryConfig = new RegistryConfig("nacos://127.0.0.1:8848");

        ServiceConfig<DemoService> demoServiceConfig = new ServiceConfig<>();
        demoServiceConfig.setInterface(DemoService.class.getName());
        demoServiceConfig.setRef(new DemoServiceImpl());
        demoServiceConfig.setVersion("1.0.0");
        demoServiceConfig.setGroup("native-group");

        DubboBootstrap.getInstance()
                .application(applicationName)
                .registry(registryConfig)
                .protocol(protocolConfig)
                .service(demoServiceConfig)
                .start()
                .await();
    }
}
