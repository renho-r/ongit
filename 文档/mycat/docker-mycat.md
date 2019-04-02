# 1. 构造镜像

```shell
wget http://dl.mycat.io/1.6.5/Mycat-server-1.6.5-release-20180122220033-linux.tar.gz
vi Dockerfile
```

```shell
FROM openjdk:8
ADD Mycat-server-1.6.5-release-20180122220033-linux.tar.gz /usr/local/
ENV MYCAT_HOME=/usr/local/mycat
EXPOSE 8066 9066
CMD ["/usr/local/mycat/bin/mycat", "console","&"]
```

# 2. 启动

```shell
docker build -t mycat:1.6.5 .
docker run --name mycat -d mycat:1.6.5
docker cp a03:/usr/local/mycat/conf .
docker stop a03
docker rm a03
docker run --name mycat -v /home/docker/mycat/conf:/usr/local/mycat/conf -p 8066:8066 -p 9066:9066 -d mycat:1.6.5
docker inspect -f '{{.Name}} - {{.NetworkSettings.IPAddress }}' $(docker ps -aq)
```

# 3. 注意

1. 连接mysql8注意

   修改mysql配置文件

   [mysqld]
   default_authentication_plugin=mysql_native_password
   max_connections=512
   [mysql]

2. mycat替换mysql8 jar包

