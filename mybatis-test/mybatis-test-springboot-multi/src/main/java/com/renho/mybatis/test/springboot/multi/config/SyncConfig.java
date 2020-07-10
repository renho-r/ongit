package com.renho.mybatis.test.springboot.multi.config;

import com.renho.mybatis.test.springboot.multi.service.IUserService;
import com.renho.mybatis.test.springboot.multi.timer.SyncTimer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: renho
 * @since: 1.0.0
 */
@Configuration
public class SyncConfig {

    @Bean
    @ConditionalOnProperty(prefix="my.sync", name = "always", matchIfMissing = true, havingValue = "false")
    public SyncTimer syncTimer(IUserService userService, MyConfig myConfig) {
        return new SyncTimer(userService, myConfig);
    }

}
