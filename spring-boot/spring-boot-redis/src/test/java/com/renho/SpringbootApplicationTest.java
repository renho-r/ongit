package com.renho;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SpringbootApplicationTest {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    public void testAddString() {
        redisTemplate.opsForValue().set("key-string0", "value-string0");
    }

    @Test
    public void testString() {
        Object value = redisTemplate.opsForValue().get("key-string0");
        assert value == null;
    }

    @Test
    public void testAddMap() {
        redisTemplate.opsForHash().put("key-map", "key-map-key0", "key-map-value0");
    }

    @Test
    public void testMap() {
        Object value = redisTemplate.opsForHash().get("key-map", "key-map-key0");
        assert value == null;
    }
}