package main

import (
	"grpc-server-go/pkg/config"
	"grpc-server-go/pkg/server"
)

func main() {
	// 加载app配置
	config.LoadAppConfig()

	// 初始化grpc server
	server.Init()
}
