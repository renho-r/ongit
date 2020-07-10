package com.renho.mybatis.test.springboot.multi.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: renho
 * @since: 1.0.0
 */
@Data
@Component
@ConfigurationProperties(prefix="my.sync")
public class MyConfig {

    private boolean always;
    private int sleepTimes = 3;
    private Worker worker = new Worker();
    private Cache cache = new Cache();

    @Data
    public static class Worker {
        private int count = 2 * Runtime.getRuntime().availableProcessors() + 1;
    }

    @Data
    public static class Cache {
        private int count = 600;
        private int threshold = 0;//???????????
    }

}
