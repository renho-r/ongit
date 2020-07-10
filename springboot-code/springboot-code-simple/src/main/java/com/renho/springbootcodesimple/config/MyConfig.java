package com.renho.springbootcodesimple.config;

import com.renho.springbootcodesimple.controller.EnvController;
import com.renho.springbootcodesimple.handlermapping.MyHandlerMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
@Configuration
public class MyConfig {

    @Autowired
    private EnvController envController;

    @Autowired
    private RequestMappingHandlerMapping requestMappingHandlerMapping;

    @Bean
    public MyHandlerMapping myHandlerMapping() {
        MyHandlerMapping mapping = new MyHandlerMapping(envController, requestMappingHandlerMapping);
        return mapping;
    }

}
