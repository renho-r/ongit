package com.renho.mybatis.test.springboot.multi.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: renho
 * @since: 1.0.0
 */
@Configuration
@Slf4j
public class MyBatisPlusConfig {

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        log.info("paginationInterceptor ...");
        return new PaginationInterceptor();
    }

}
