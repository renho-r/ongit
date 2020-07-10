1 直接路由

```
#linux开启ip转发
echo 1 > /proc/sys/net/ipv4/ip_forward
iptables -L
#启用转发1 每次重启后变为DROP，保存后再加载也无效
iptables -P FORWARD ACCEPT
#启用转发2 需要保存后再加载 https://docs.docker.com/network/iptables/
iptables -I DOCKER-USER -i wlan0 -o docker0 -j ACCEPT
```

iptables保存

```shell
vi /etc/network/if-pre-up.d/iptables

#!/bin/sh
/sbin/iptables-restore < /etc/iptables

chmod +x /etc/network/if-pre-up.d/iptables
iptables-save > /etc/iptables
```



其它机器配置路由

```cmd
#linux
route add -net 172.156.0.0/24 gw 192.168.0.156
#win route.cmd
%1 mshta vbscript:CreateObject("Shell.Application").ShellExecute("cmd.exe","/c "^&chr(34)^&"%~0"^&chr(34)^&" ::","%cd%","runas",1)(window.close)&&exit
route add 172.150.0.0 mask 255.255.255.0 192.168.0.150
route add 172.152.0.0 mask 255.255.255.0 192.168.0.152
route add 172.154.0.0 mask 255.255.255.0 192.168.0.154
route add 172.156.0.0 mask 255.255.255.0 192.168.0.156
```

