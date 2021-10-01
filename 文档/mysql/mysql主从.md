# master

1. 配置文件`my.cnf`

   ```cnf
   [mysqld]
   log-bin=mysql-bin
   server-id=156
   ```

2. 建用户

   ```sql
   CREATE USER 'mysql154'@'192.168.0.154' IDENTIFIED BY 'mysql154';
   GRANT REPLICATION SLAVE ON *.* TO 'mysql154'@'192.168.0.154';
   flush privileges;
   show master status\G
   ```

3. 记录位置

   ```text
   mysql-bin.000001
   949
   ```

4. 同步数据

   ```shell
   flush tables with read lock;
   mysqldump -u root --password=root123 --all-databases > backup.sql
   ```

# slave

1. 配置文件`my.cnf`

```cnf
server-id=154
read_only=1
```

2. 导入数据

```shell
mysql -u root -h 192.168.0.154 -proot123 -P3306 < backup.sql
```

3. 设置位置

```sql
CHANGE MASTER TO
MASTER_HOST='192.168.0.156',
MASTER_USER='mysql154',
MASTER_PASSWORD='mysql154',
MASTER_LOG_FILE='mysql-bin.000001',
MASTER_LOG_POS=949;
```

4. 启动

```sql
START slave;
show slave status\G
```





