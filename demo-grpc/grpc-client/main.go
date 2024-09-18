package main

import (
	"context"
	"flag"
	"fmt"
	"log"

	pb "grpc-client/pb"

	"google.golang.org/grpc"
	"google.golang.org/grpc/credentials/insecure"
)

var (
	addr = flag.String("addr", "localhost:9201", "the address to connect to")
	name = flag.String("name", "grpc-client", "client name")
)

func main() {
	flag.Parse()

	conn, err := grpc.NewClient(*addr, grpc.WithTransportCredentials(insecure.NewCredentials()))
	if err != nil {
		log.Fatalf("connect grpc server fail: %v", err)
	}

	defer conn.Close()

	helloworldClient := pb.NewHelloServiceClient(conn)
	response, err := helloworldClient.SayHello(context.Background(), &pb.HelloRequest{Source: *name, Message: "go client message"})
	if err != nil {
		log.Printf("[ERROR] helloworld request fail: %v", err)
	}
	fmt.Printf("Helloworld Reponse: [%+v] \n", response)

	userServiceClient := pb.NewUserServiceClient(conn)
	userInfo, err := userServiceClient.UserInfo(context.Background(), &pb.UserInfoRequest{UserId: "userId1234"})
	if err != nil {
		log.Printf("[ERROR] userInfo request fail: %v", err)
	}
	fmt.Printf("UserInfo Response: [%+v] \n", userInfo)
}
