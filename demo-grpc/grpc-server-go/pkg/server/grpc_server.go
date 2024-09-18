package server

import (
	"grpc-server-go/pkg/config"
	"grpc-server-go/pkg/pb"
	"log"
	"net"

	"google.golang.org/grpc"
)

func Init() {
	grpcServer := grpc.NewServer()

	registerService(grpcServer)

	// 开启grpc server监听
	listen, err := net.Listen("tcp", ":"+config.App.GrpcPort)
	if err != nil {
		log.Fatalf("net listen fail: %v", err)
	}

	if err := grpcServer.Serve(listen); err != nil {
		log.Fatalf("grpc server start up failed: %v", err)
	}

	log.Printf("server [%s] listening: %s", config.App.AppName, listen.Addr())
}

func registerService(grpcServer *grpc.Server) {
	pb.RegisterHelloServiceServer(grpcServer, &HelloService{})
	pb.RegisterUserServiceServer(grpcServer, &UserService{})
}
