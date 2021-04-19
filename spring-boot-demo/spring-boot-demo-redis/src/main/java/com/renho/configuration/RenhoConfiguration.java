package com.renho.configuration;

import io.lettuce.core.AbstractRedisClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

/**
 * @author renho
 * @date 2021/1/8
 */
@Configuration
public class RenhoConfiguration {

    @Bean
    public AbstractRedisClient client(LettuceConnectionFactory lettuceConnectionFactory) {
        Field field = ReflectionUtils.findField(LettuceConnectionFactory.class, "client", AbstractRedisClient.class);
        field.setAccessible(true);
        AbstractRedisClient client = (AbstractRedisClient) ReflectionUtils.getField(field, lettuceConnectionFactory);
        return client;
    }

}
