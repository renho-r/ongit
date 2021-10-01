```shell
# macvlan 网卡开启混杂 只能有线网卡
ifconfig eth0 promisc 
docker network create -d macvlan --subnet=192.168.0.0/24 --ip-range=192.168.0.17/28 --gateway=192.168.0.1 -o macvlan_mode=bridge -o parent=eth0 bridge-host
docker run -itd --restart=always --name centos --network bridge-host --ip=192.168.0.17 centos:7
```

```shell
# ipvlan 可以无线网卡
docker network create -d ipvlan --subnet=192.168.0.0/24 --ip-range=192.168.0.72/29 --gateway=192.168.0.1 -o ipvlan_mode=l2 -o parent=wlan0 renho-ip

docker run \
--privileged=true \
--name centos7 \
--hostname 156-centos7 \
--net renho-ip \
--ip 192.168.0.72 \
--restart=unless-stopped \
-d centos:7 \
/usr/sbin/init

docker network connect renho-ip --ip 192.168.0.72 centos7
```

