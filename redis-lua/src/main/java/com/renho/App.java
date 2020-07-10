package com.renho;

import com.google.common.collect.Lists;
import com.google.common.io.Files;
import redis.clients.jedis.Jedis;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.CountDownLatch;

/**
 * Hello world!
 *
 */
public class App  {

    public static void main( String[] args ) throws IOException {
        final CountDownLatch latch = new CountDownLatch(1);

        for (int i = 0; i < 70; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        latch.await();
                        System.out.println("请求是否被执行：" + acquire());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        }

        latch.countDown();
    }

    public static boolean acquire() throws IOException {

        String luaScript = Files.toString(new File("redis-limit.lua"), Charset.defaultCharset());
        Jedis jedis = new Jedis("192.168.111.130", 6379);
        String key = "ip:" + System.currentTimeMillis() / 1000;
        String limit = "3";
        Long thisCount = (Long) jedis.eval(luaScript, Lists.newArrayList(key), Lists.newArrayList(limit));
        return thisCount.equals(1L);
    }
}
