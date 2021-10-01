package com.renho.captcha.config;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.TimeUnit;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOriginPatterns("*").allowedMethods("GET", "HEAD", "POST","PUT", "DELETE", "OPTIONS").allowCredentials(true).maxAge(3600);
    }

    @Bean
    public Cache<String, String> captchaCache() {
        Cache<String, String> cache = CacheBuilder.newBuilder()
                .maximumSize(10000) // 设置缓存的最大容量
                .expireAfterWrite(10, TimeUnit.MINUTES) // 设置缓存在写入一分钟后失效
                .concurrencyLevel(10) // 设置并发级别为10
                .recordStats() // 开启缓存统计
                .build();
        return cache;
    }
}