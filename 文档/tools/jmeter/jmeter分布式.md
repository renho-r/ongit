```shell
wget https://mirrors.tuna.tsinghua.edu.cn/apache//jmeter/binaries/apache-jmeter-5.3.tgz
```

slave

修改vi jmeter.properties

```properties
vi jmeter.properties
server_port=1199
server.rmi.localport=1199
server.rmi.ssl.disable=true
```

修改jmeter-server

```shell
vi jmeter-server
RMI_HOST_DEF=-Djava.rmi.server.hostname=192.168.0.154
```

启动

```shell
./jmeter-server
```

master

修改jmeter.properties

```properties
server.rmi.ssl.disable=true
remote_hosts=192.168.0.154:1199
```

修改jmeter.bat

```shell
set rmi_host=-Djava.rmi.server.hostname=192.168.0.109
rem Collect the settings defined above
if not defined JMETER_COMPLETE_ARGS (
    set ARGS=%JAVA9_OPTS% %DUMP% %HEAP% %VERBOSE_GC% %GC_ALGO% %DDRAW% %SYSTEM_PROPS% %JMETER_LANGUAGE% %RUN_IN_DOCKER% %rmi_host%
) else (
    set ARGS=
)
```

