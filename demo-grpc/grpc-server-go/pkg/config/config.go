package config

import (
	"log"
	"sync"

	"github.com/spf13/viper"
)

// =============== 配置入口 ===============
type Application struct {
	AppName  string
	GrpcPort string
}

var (
	App     *Application
	appOnce sync.Once
)

// 加载根目录dev.env配置文件，仅加载一次到App中
func LoadAppConfig() {
	viper.SetConfigFile("dev.env")
	viper.SetConfigType("env")
	viper.AddConfigPath(".")

	err := viper.ReadInConfig()
	if err != nil {
		log.Fatalf("Error reading config file: %s", err)
	}

	appOnce.Do(
		func() {
			App = &Application{
				AppName:  viper.GetString("app_name"),
				GrpcPort: viper.GetString("grpc_port"),
			}
		},
	)
}
