package com.renho;

import io.lettuce.core.AbstractRedisClient;
import io.lettuce.core.RedisClient;
import io.lettuce.core.api.sync.RedisCommands;
import io.lettuce.core.cluster.RedisClusterClient;
import io.lettuce.core.cluster.api.sync.RedisClusterCommands;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author renho
 * @date 2021/1/8
 */
@Component
public class MyCommandLineRunner implements CommandLineRunner {

    @Autowired
    private LettuceConnectionFactory lettuceConnectionFactory;

    @Autowired
    private AbstractRedisClient client;

    @Override
    public void run(String... args) throws Exception {
        if (client instanceof RedisClient) {
            System.out.println("RedisClient");
            RedisClient redisClient = (RedisClient) client;
            RedisCommands commands = redisClient.connect().sync();
            commands.setnx(UUID.randomUUID().toString(), "renho");
        } else if (client instanceof RedisClusterClient) {
            System.out.println("RedisClusterClient");
            RedisClusterClient redisClusterClient = (RedisClusterClient) client;
            RedisClusterCommands commands = redisClusterClient.connect().sync();
            commands.setnx(UUID.randomUUID().toString(), "renho");
        }
    }
}
