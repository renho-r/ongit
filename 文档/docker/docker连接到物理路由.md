```
#网卡开启混杂 只能有线网卡
ifconfig eth0 promisc 
docker network create -d macvlan --subnet=192.168.0.0/24 --ip-range=192.168.0.17/28 --gateway=192.168.0.1 -o macvlan_mode=bridge -o parent=eth0 bridge-host
docker run -itd --restart=always --name centos --network bridge-host --ip=192.168.0.17 centos:7
```