package com.renho.springbootcodesimple.config;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */

import com.renho.springbootcodesimple.interceptor.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class RegisterInterceptorConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor());

        super.addInterceptors(registry);
    }
}
