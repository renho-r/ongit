# 1.启动

java -jar arthas-boot.jar

# 2.反编译

jad com.alibaba.dubbo.rpc.Protocol$Adaptive

# 3.

启动

./as.sh

help

```shell
trace com.wondersgroup.osf.framework.core.idgenerator.db.DbIdGenerator get
trace com.wondersgroup.osf.framework.core.idgenerator.db.IdKeeper next
```