# 1.基础

```shell
influx -precision rfc3339
influx -username 'admin' -password 'admin' -precision rfc3339
influx -username 'linux' -password 'linux'
SHOW USERS;
CREATE USER admin WITH PASSWORD 'admin' WITH ALL PRIVILEGES;
create user linux with password 'linux';
SET PASSWORD FOR "linux" = 'linux';
create database linux;
GRANT ALL ON "linux" TO "linux";
GRANT DROP ON "linux" TO "linux";
SHOW USERS;
show databases;
auth
use linux;
SHOW MEASUREMENTS;
insert test_measurement,hostname=server01 value=442221834240i 1435362189575692182;
select * from test_measurement;
select count(*) from test_measurement;
select count(*) from monitorDO;
SELECT * FROM monitorDO LIMIT 1;

drop database oe;
drop measurement test_measurement;
drop from vmstat;
```

```shell
vi /etc/influxdb/influxdb.conf
```

```config
[http]  
  enabled = true  
  bind-address = ":8086"  
  auth-enabled = true
  log-enabled = true  
  write-tracing = false  
  pprof-enabled = false  
  https-enabled = false  
  https-certificate = "/etc/ssl/influxdb.pem"
```

# 2.操作

## 2.1 插入

```shell
#
insert vmstat r=1,b=0,swpd=0,free=2283644,buff=29092,cache=1478316,si=0,so=0,bi=13,bo=60,in=43,cs=56,us=6,sy=2,id=91,wa=1,st=0
insert vmstat r=1,b=0,swpd=0,free=2284680,buff=29104,cache=1478240,si=0,so=0,bi=0,bo=0,in=174,cs=97,us=25,sy=0,id=75,wa=0,st=0 1594384532093000000
```

## 2.2 查询

```sql
select <fields> from <tbname> [ into_clause ] [ where_clause ]              
          [ group_by_clause ] [ order_by_clause ] [ limit_clause ]              
          [ offset_clause ] [ slimit_clause ] [ soffset_clause ]
fields : 要查询的字段，查询全部可以用*
tbname : 数据表名称
into_clause : select ... into （可选）
where_clause : where条件域（可选）
group_by_clause : group by相关（可选）
order_by_clause : order by相关（可选）
limit_clause : limit相关（可选）
offset_clause : offset相关（可选）
slimit_clause : slimit相关（可选）
soffset_clause : soffset相关（可选）
```



```shell
select * from vmstat;
select * from vmstat where b > 0;
select * from vmstat where b > 0 limit 1;

SELECT mean("b") FROM "vmstat" WHERE time >= 1594385150000ms and time <= 1594385360000ms GROUP BY time(1s) fill(null)
SELECT mean(*) FROM "vmstat" WHERE time >= 1594385150000ms and time <= 1594385360000ms GROUP BY time(1s) fill(null)
SELECT last("r") FROM "vmstat" WHERE ("r" > 0) AND time >= 1594385150000ms and time <= 1594385360000ms
```

