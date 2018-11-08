package com.renho.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */

@Configuration
public class JacksonConf {

    @Bean
    public ObjectMapper getObjectMapper(){
        ObjectMapper objectMapper=new ObjectMapper();
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:SS"));
        return objectMapper;
    }
}