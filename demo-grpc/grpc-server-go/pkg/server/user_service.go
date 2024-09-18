package server

import (
	"context"
	"grpc-server-go/pkg/config"
	"grpc-server-go/pkg/pb"
	"log"
	"time"
)

type UserService struct {
	pb.UnimplementedUserServiceServer
}

func (userService *UserService) UserInfo(ctx context.Context, userInfoRequest *pb.UserInfoRequest) (*pb.UserInfo, error) {

	userId := userInfoRequest.UserId
	appName := config.App.AppName
	log.Printf("[%s] Recieve [%s]", appName, userId)

	return &pb.UserInfo{
		UserId:   userId,
		UserName: "testName",
		Age:      17,
		Addresses: []*pb.Address{
			{Street: "YiChengRoad", City: "Hangzhou"},
			{Street: "GuangHuaRoad", City: "Nanjing"},
		},
		CreatedAt: uint64(time.Now().UnixMilli()),
	}, nil
}
