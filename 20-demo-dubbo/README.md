
# nacos
nacos docker 单机启动
访问控制台：http://localhost:8848/nacos
```shell
docker pull nacos/nacos-server

docker run --name nacos -d -p 8848:8848 -p 9848:9848 -p 9849:9849 -e MODE=standalone nacos/nacos-server
```

# Dubbo
[Dubbo-负载均衡](https://cn.dubbo.apache.org/zh-cn/overview/mannual/java-sdk/tasks/service-discovery/loadbalance/)

dubbo url
```shell
dubbo://172.23.128.1:50052/com.xiaohan.demo.dubbo.api.service.HelloService?anyhost=true&application=demo-dubbo-provider&background=false&bind.ip=172.23.128.1&bind.port=50052&check.serializable=false&deprecated=false&dubbo=2.0.2&dynamic=true&executor-management-mode=isolation&file-cache=true&generic=false&interface=com.xiaohan.demo.dubbo.api.service.HelloService&methods=sayHello&pid=22172&prefer.serialization=hessian2&release=3.3.0&revision=1.0.0&serialization=hessian2&service-name-mapping=true&side=provider&timeout=5000&timestamp=1726420277565&version=1.0.0
```

## 负载均衡

