```shell
docker search mysql
docker pull mysql
docker images
docker run --name mydb -e MYSQL_ROOT_PASSWORD=root123 -d mysql
docker ps -a
docker exec -it 4c /bin/bash
mkdir -p /home/docker/mydb/mysql
docker cp 4c:/etc/mysql/conf.d /home/docker/mydb/mysql/conf
mkdir -p /home/docker/mydb/mysql/datadir
docker stop 4c
docker rm 4c
docker run --name mydb -v /home/docker/mydb/mysql/conf:/etc/mysql/conf.d -v /home/docker/mydb/mysql/datadir:/var/lib/mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root123 -d mysql


mysql8密码
ALTER USER root IDENTIFIED WITH mysql_native_password BY 'root123';
```

