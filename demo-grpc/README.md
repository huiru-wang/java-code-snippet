# Grpc

## protoc

[protoc release download](https://github.com/protocolbuffers/protobuf/releases)

解压后，将protoc\bin路径配置到环境变量中

## 编写proto文件


## 编译proto文件

### 生成proto文件 和 grpc文件
```shell
# 生成 go proto文件
protoc --go_out=./grpc-server-go/pkg --go_opt=paths=source_relative .\pb\*.proto
protoc --go_out=./grpc-client --go_opt=paths=source_relative .\pb\*.proto

# 生成go grpc server文件
protoc --go-grpc_out=./grpc-server-go/pkg --go-grpc_opt=paths=source_relative .\pb\*.proto
protoc --go-grpc_out=./grpc-client --go-grpc_opt=paths=source_relative .\pb\*.proto
```
- out路径默认生成pb文件夹
- `--go_opt=paths=source_relative`：go_out参数使用相对路径


## 启动server

```PowerShell
cd .\grpc-server-go\
go run .\cmd\main.go
```

## 启动客户端

```PowerShell
cd .\grpc-client\
go run .\main.go --addr 127.0.0.1:9201 --name client-app
```