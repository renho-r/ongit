package com.renho.test.mybatisplus.config;

import com.baomidou.mybatisplus.core.incrementer.IKeyGenerator;
import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import com.renho.test.mybatisplus.idgenerator.CustomIdGenerator;
import com.renho.test.mybatisplus.keygenerator.CustomKeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author renho
 * @date 2020/10/23
 */
@Configuration
public class KeyGeneratorConfig {

    @Bean
    public IKeyGenerator keyGenerator() {
        return new CustomKeyGenerator();
    }

    @Bean
    public IdentifierGenerator idGenerator() {
        return new CustomIdGenerator();
    }
}
