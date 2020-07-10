package com.renho.test.configuration.config;

import com.renho.test.configuration.test.domain.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: renho
 * @since: 1.0.0
 */
@Configuration
public class ConfigurationOne {

    @Bean
    @ConditionalOnMissingBean
    public User user() {
        return new User();
    }
}
