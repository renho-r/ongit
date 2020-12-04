package com.renho.springbootcode.config;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.HandlerMapping;

/**
 * @author renho
 * @date 2020/11/27
 */
@Configuration
public class MyWebMvcRegistrationsConfig {

//    @Bean
    public WebMvcRegistrations webMvcRegistrations() {
        return new MyWebMvcRegistrations();
    }

    @Bean
    public HandlerMapping myRequestMappingHandlerMapping() {
        return new MyRequestMappingHandlerMapping();
    }

    @Bean
    public HandlerAdapter myHandlerAdapter() {
        return new MyHandlerAdapter();
    }
}
