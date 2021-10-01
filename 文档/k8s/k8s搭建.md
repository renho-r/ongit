## 1. Rancher安装

`docker`安装`rancher`，其它不需要

1. 禁止`swap`
2. 开启`ip`转发
3. 安装`docker`
4. 配置国内源
5. 安装`rancher`，不要使用`80`端口

```shell
docker run --privileged -d --restart=always --name rancher -v /etc/localtime:/etc/localtime -p 3000:80 -p 3443:443 rancher/rancher
https://192.168.0.200:3443
```

本机安装kube

```shell
curl https://storage.googleapis.com/kubernetes-release/release/v1.18.0/bin/linux/amd64/kubectl
chmod +x ./kubectl
mv ./kubectl /usr/local/bin/kubectl
vi ~/.kube/config
内容rancher中yaml 
```



## 2.本地`k8s`

### 1. 禁止swap分区

暂时禁止

```
sudo swapoff -a
```

永久禁止, 注释掉swap那行

```
sudo vi /etc/fstab #注释掉swap一行
```

### 2.开启`IP`转发

```shell
vi /etc/sysctl.conf
net.ipv4.ip_forward=1
sysctl -p
```

### 3.安装docker

```shell
sudo apt update
sudo apt install docker.io
sudo systemctl start docker
sudo systemctl enable docker
```

### 4.配置国内源

```shell
sudo mkdir -p /etc/docker
sudo tee /etc/docker/daemon.json <<-'EOF'
{
  "registry-mirrors": ["https://6n3qqtu3.mirror.aliyuncs.com"],
  "insecure-registries":["192.168.0.105:6000"],
  "exec-opts": [
    "native.cgroupdriver=systemd"
  ]
}
EOF
sudo systemctl daemon-reload
sudo systemctl restart docker
```

### 5.安装`k8s`

所有节点安装

```shell
sudo apt-get update && sudo apt-get install -y ca-certificates curl software-properties-common apt-transport-https curl
#添加证书
curl -s https://mirrors.aliyun.com/kubernetes/apt/doc/apt-key.gpg | sudo apt-key add -
#添加apt源
sudo tee /etc/apt/sources.list.d/kubernetes.list <<EOF 
deb https://mirrors.aliyun.com/kubernetes/apt/ kubernetes-xenial main
EOF

sudo apt-get update
sudo apt-get install -y kubelet kubeadm kubectl
#阻止自动更新
sudo apt-mark hold kubelet kubeadm kubectl
```

### 6.初始化

```shell
#失败 需要国内镜像
sudo kubeadm init

#失败时执行
sudo kubeadm reset
sudo kubeadm init --image-repository registry.aliyuncs.com/google_containers --ignore-preflight-errors=Swap

```

初始化完成后提示执行

```shell
mkdir -p $HOME/.kube
sudo cp -i /etc/kubernetes/admin.conf $HOME/.kube/config
#root用户可不执行
sudo chown $(id -u):$(id -g) $HOME/.kube/config
#如果root用户可以
export KUBECONFIG=/etc/kubernetes/admin.conf
```

记录加入集群命令

```shell
kubeadm join 192.168.0.200:6443 --token g75bk0.8zcx7pmr7n3vszj9 --discovery-token-ca-cert-hash sha256:ca8e414dfb30952462a39461b969f64bc1911d28cf07840a64cf137c11ae3d5c 
```

单机设置

```shell
kubectl taint nodes --all node-role.kubernetes.io/master-
```

### 7.安装

```shell
docker pull rancher/rancher
docker run --privileged -d --restart=always --name rancher -v /etc/localtime:/etc/localtime -p 80:80 -p 443:443 rancher/rancher
```

访问

```shell
http://192.168.0.200
```

导入已有k8s集群

选择 **添加集群** 提示执行

```shell
curl --insecure -sfL https://192.168.0.200/v3/import/sflf45v4sckfw5wj9kjmp5wllr758l248h759ffdfvr4krn7lvmk26_c-tk5c7.yaml | kubectl apply -f -    

```

查看pod

```shell
kubectl get nodes
kubectl get pods -n cattle-system -o wide
kubectl get pods --all-namespaces
kubectl logs -f cattle-cluster-agent-78f989fff9-fjzzn -n cattle-system
kubectl describe pod cattle-cluster-agent-78f989fff9-fjzzn -n cattle-system
kubectl get deployment --all-namespaces
kubectl delete pods cattle-cluster-agent-5c8cd98f77-zrmr9 -n cattle-system
kubectl delete deployment cattle-cluster-agent -n cattle-system
kubectl get namespace
kubeadm token create --print-join-command
kubectl label node k8s-node0 node-role.kubernetes.io/worker=worker
kubectl delete namespace cattle-impersonation-system
kubectl delete namespace cattle-system
```

安装网络插件

```shell
kubectl apply -f  https://docs.projectcalico.org/manifests/calico.yaml
```

### 8.节点加入集群

```shell
# master
scp -r /etc/kubernetes/admin.conf k8s-node0:/etc/kubernetes/admin.conf
#node
echo "export KUBECONFIG=/etc/kubernetes/admin.conf" >> ~/.bash_profile
source ~/.bash_profile




```

### 9.卸载

```shell
kubeadm reset -f
modprobe -r ipip
lsmod
rm -rf ~/.kube/
rm -rf /etc/kubernetes/
rm -rf /etc/systemd/system/kubelet.service.d
rm -rf /etc/systemd/system/kubelet.service
rm -rf /usr/bin/kube*
rm -rf /etc/cni
rm -rf /opt/cni
rm -rf /var/lib/etcd
rm -rf /var/etcd
yum clean all
yum remove kube*


```

### 10.搭建`docker registry`

```shell
docker run -itd -v /data/registry:/var/lib/registry -p 5000:5000 --restart=always --name registry registry:latest
curl http://192.168.0.105:6000/v2/_catalog
curl -X GET http://192.168.0.105:6000/v2/eureka-jenkins/tags/list
curl  --header "Accept: application/vnd.docker.distribution.manifest.v2+json" -I -X GET http://192.168.0.105:6000/v2/eureka-jenkins/manifests/latest
curl -I -X DELETE ttp://192.168.0.105:6000/v2/eureka-jenkins/manifests/sha256:403210914a785fcbc6d2bdb4945cc82e63074f438b28b2ccae2ea3387183944a
docker exec 5b bin/registry garbage-collect /etc/docker/registry/config.yml

docker exec 5b rm -rf /var/lib/registry/docker/registry/v2/repositories/eureka-jenkins

```

```shell
# 修改
vi /etc/docker/daemon.json

{
  "registry-mirrors": ["https://6n3qqtu3.mirror.aliyuncs.com"],
  "insecure-registries": [ "192.168.0.105:6000"],
  "exec-opts": [
    "native.cgroupdriver=systemd"
  ]
}

systemctl restart docker
docker build -t eureka:v1 .
docker tag eureka:v1 192.168.0.105:6000/eureka:v1
docker push 192.168.0.105:6000/eureka:v1
```

```shell
docker rm -f $(docker ps -qa)
# docker rmi -f $(docker images -q)
docker volume rm $(docker volume ls -q)
for mount in (mount | grep tmpfs | grep '/var/lib/kubelet' | awk '{ print $3 }') /var/lib/kubelet /var/lib/rancher; do umount mount; done
rm -rf /etc/ceph \
       /etc/cni \
       /etc/kubernetes \
       /opt/cni \
       /opt/rke \
       /run/secrets/kubernetes.io \
       /run/calico \
       /run/flannel \
       /var/lib/calico \
       /var/lib/etcd \
       /var/lib/cni \
       /var/lib/kubelet \
       /var/lib/rancher/rke/log \
       /var/log/containers \
       /var/log/pods \
       /var/run/calico
rm -f /var/lib/containerd/io.containerd.metadata.v1.bolt/meta.db
sudo systemctl restart containerd
sudo systemctl restart docker
```

```shell


rm -f /var/lib/containerd/io.containerd.metadata.v1.bolt/meta.db
sudo systemctl restart containerd
sudo systemctl restart docker
```

