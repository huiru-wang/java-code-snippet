package server

import (
	"context"
	"grpc-server-go/pkg/config"
	"grpc-server-go/pkg/pb"
	"log"
)

type HelloService struct {
	pb.UnimplementedHelloServiceServer
}

func (helloService *HelloService) SayHello(ctx context.Context, helloRequest *pb.HelloRequest) (*pb.HelloResponse, error) {
	source := helloRequest.Source
	message := helloRequest.Message

	appName := config.App.AppName
	log.Printf("[%s] Recieve [%s] From [%s]", appName, message, source)

	return &pb.HelloResponse{
		Source:  "grpc-go-server",
		Message: "Success",
	}, nil
}
