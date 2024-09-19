# 使用官方的Java基础镜像作为基础环境
FROM openjdk:17-alpine

# 设置环境变量（可根据实际需求调整）
ENV SPRING_PROFILES_ACTIVE=prod
ENV SERVER_PORT=8080

# 设置工作目录
WORKDIR /app

# 复制应用所需的文件到容器中
COPY target/demo-spring-cicd-1.0-SNAPSHOT.jar app.jar

# 声明应用运行时需要暴露的端口
EXPOSE 8080

# 定义容器启动时执行的命令
ENTRYPOINT ["java", "-jar", "app.jar"]
