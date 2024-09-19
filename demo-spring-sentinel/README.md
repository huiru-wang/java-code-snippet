

# dashboard

[release包下载地址](https://github.com/alibaba/Sentinel/releases)

```shell
java -jar sentinel-dashboard-1.8.6.jar -Dserver.port=8858 -Dcsp.sentinel.dashboard.server=localhost:8858 -Dproject.name=sentinel-dashboard
```

```shell
docker pull bladex/sentinel-dashboard:1.8.6

docker run -d --name sentinel-dashboard -p 8858:8858 bladex/sentinel-dashboard:1.8.6
```