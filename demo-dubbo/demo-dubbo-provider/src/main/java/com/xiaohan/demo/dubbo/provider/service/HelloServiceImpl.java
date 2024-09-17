package com.xiaohan.demo.dubbo.provider.service;

import com.xiaohan.demo.dubbo.api.constants.ErrorConstants;
import com.xiaohan.demo.dubbo.api.model.HelloRequest;
import com.xiaohan.demo.dubbo.api.model.HelloResponse;
import com.xiaohan.demo.dubbo.api.model.ServiceResult;
import com.xiaohan.demo.dubbo.api.service.HelloService;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.rpc.RpcContext;
import org.apache.dubbo.rpc.RpcServiceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DubboService(version = "1.0.0", timeout = 5000)
public class HelloServiceImpl implements HelloService {

    private static final Logger log = LoggerFactory.getLogger(HelloServiceImpl.class);

    @Override
    public ServiceResult<HelloResponse> sayHello(HelloRequest helloRequest) {
        String source = helloRequest.getSource();
        String message = helloRequest.getMessage();

        if (null == source || source.isEmpty()) {
            return ServiceResult.fail(ErrorConstants.INVALID_PARAM);
        }
        RpcServiceContext serviceContext = RpcContext.getServiceContext();
        HelloResponse response = getHelloResponse(serviceContext, message, source);
        return ServiceResult.success(response);
    }

    private HelloResponse getHelloResponse(RpcServiceContext serviceContext, String message, String source) {
        String remoteApplicationName = serviceContext.getRemoteApplicationName();
        int localPort = serviceContext.getLocalPort();
        String methodName = serviceContext.getMethodName();

        String metaInfo = String.format("[remoteApplication: %s] [localPort: %d] [methodName: %s] [message: %s]",
                remoteApplicationName, localPort, methodName, message);
        log.info(metaInfo);

        HelloResponse response = new HelloResponse();
        response.setSource(source);
        response.setMessage("response from [Provider], got message: [ " + message + " ]");
        return response;
    }
}
