package com.renho.test.mybatisplus.common.core.idgenerator.redis;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

@Service
@Configuration
public class RedisClient {

    @Value("${redis.clusterNodes}")
    private  String redisNodes;

    public JedisCluster getPool(){
        Set<HostAndPort> nodes = new HashSet<>();
        String [] ipPort = redisNodes.split(",");
        for (int i=0;i<ipPort.length;i++) {
            String [] ipAndPort = ipPort[i].split(":");
            nodes.add(new HostAndPort(ipAndPort[0],Integer.valueOf(ipAndPort[1])));
        }
        JedisCluster cluster = new JedisCluster(nodes,getPoolConfig());
        return cluster;
    }
    public GenericObjectPoolConfig getPoolConfig(){
        GenericObjectPoolConfig config = new GenericObjectPoolConfig();
        //确保取出来的可用
        config.setTestOnBorrow(false);
        config.setTestOnReturn(false);
        config.setTestWhileIdle(true);
        //设置空闲时保留8个连接
        config.setMinIdle(8);
        //没有连接时的等待时间设置成10毫秒
        config.setMaxWaitMillis(10);
        //最大连接和最小连接，最小空闲连接一样的时候，就不需要设置淘汰策略了
        return config;
    }

}
