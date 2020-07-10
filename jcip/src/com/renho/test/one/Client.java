package com.renho.test.one;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class Client {

    public static void main(String[] args) throws InterruptedException {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("192.168.111.130");
        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: " + jedis.ping());

        redis.clients.jedis.Client client = jedis.getClient();
        for (int i = 0; i < 50000000; i++) {
            try {
                client.set(UUID.randomUUID().toString(), "15940088523");
                System.out.println("set: " + i);
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
        client.close();
    }

}
