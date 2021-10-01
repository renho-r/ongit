# 1.准备

```shell
mkdir cluster-test
mkdir -p cluster-test/7000/logs
mkdir -p cluster-test/7001/logs
mkdir -p cluster-test/7002/logs
mkdir -p cluster-test/7003/logs
mkdir -p cluster-test/7004/logs
mkdir -p cluster-test/7005/logs
```

# 2.安装redis

```shell
yum -y install gcc gcc-c++
make MALLOC=libc
make PREFIX=/root/redis install
```

# 3.修改配置文件

```shell
vi redis.conf
```

主要修改配置内容
```config
bind 0.0.0.0  //绑定服务器IP地址
port 7000  //绑定端口号，必须修改，以此来区分Redis实例
daemonize yes  //后台运行
pidfile /var/run/redis_7000.pid  //修改pid进程文件名，以端口号命名
logfile "/root/cluster-test/7000/logs/7000.log"  //修改日志文件名称，以端口号为目录来区分
dir /root/cluster-test/7000/  //修改数据文件存放地址，以端口号为目录名来区分
cluster-enabled yes  //启用集群
cluster-config-file nodes-7000.conf  //配置每个节点的配置文件，同样以端口号为名称
cluster-node-timeout 15000  //配置集群节点的超时时间，可改可不改
appendonly yes  //启动AOF增量持久化策略
appendfsync always  //发生改变就记录日志
appendfilename "appendonly-7000.aof"
```

复制到每个目录，并修改各端口7000-7005

# 4.安装ruby

```shell
安装RVM
gpg --keyserver hkp://keys.gnupg.net --recv-keys 409B6B1796C275462A1703113804BB82D39DC0E3 7D2BAF1CF37B13E2069D6956105BD0E739499BDB 
curl -sSL https://get.rvm.io | bash -s stable
find / -name rvm -print
source /usr/local/rvm/scripts/rvm
查看rvm库中已知的ruby版本
rvm list known
安装一个ruby版本
rvm install 2.4.1
使用一个ruby版本
rvm use 2.4.1
设置默认版本
rvm use 2.4.1 --default
卸载一个已知版本
rvm remove 2.3.4
```

# 5.安装redis的ruby接口程序

```shell
gem install redis
```

# 6.启动redis各节点

```shell
./redis-server /root/cluster-test/7000/redis.conf
./redis-server /root/cluster-test/7001/redis.conf
./redis-server /root/cluster-test/7002/redis.conf
./redis-server /root/cluster-test/7003/redis.conf
./redis-server /root/cluster-test/7004/redis.conf
./redis-server /root/cluster-test/7005/redis.conf
```

# 7.启动配置集群

```shell
cp /root/redis-4.0.14/src/redis-trib.rb /root/redis/bin/
ruby redis-trib.rb  create --replicas 1 192.168.111.139:7000 192.168.111.139:7001 192.168.111.139:7002 192.168.111.139:7003 192.168.111.139:7004 192.168.111.139:7005 
```

# 8.集群命令

```shell
./redis-cli -c -p 7000
>cluster nodes
./redis-cli -c -p 7000 cluster nodes
./redis-cli --cluster info 127.0.0.1:6389
./redis-cli -p 7000
	cluster nodes
	cluster info
./redis-cli -c --cluster call 127.0.0.1:6389 keys \*
```

# 9. redis5.0新增redis-cli方式

Redis Cluster 在5.0之后取消了ruby脚本 **redis-trib.rb**的支持（手动命令行添加集群的方式不变），集合到redis-cli里，避免了再安装ruby的相关环境。

```conf
#redis.conf
cluster-enabled yes
#每个节点必须不同
cluster-config-file 154-6379.conf
cluster-require-full-coverage yes
#需要设置
cluster-announce-ip 172.150.0.2
#必须10000 + port
cluster-announce-bus-port 16379
```

```shell
redis-cli --cluster create 172.154.0.2:6379 172.152.0.2:6379 172.150.0.2:6379
```

```shell
redis-cli -c -p 6379 -h 172.154.0.2
```

```shell
redis-cli -c -p 6379 -h 172.154.0.2
cluster nodes
cluster info
```

