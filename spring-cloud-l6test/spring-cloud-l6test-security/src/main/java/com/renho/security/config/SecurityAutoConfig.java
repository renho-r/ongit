package com.renho.security.config;

import com.renho.security.MyAccessDecisionManager;
import com.renho.security.MyFilterSecurityInterceptor;
import com.renho.security.MyMetadataSourceService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityAutoConfig {

    @Bean
    @ConditionalOnMissingBean
    public MyAccessDecisionManager leafAccessDecisionManager() {
        return new MyAccessDecisionManager();
    }

    @Bean
    @ConditionalOnMissingBean
    public MyFilterSecurityInterceptor leafFilterSecurityInterceptor() {
        return new MyFilterSecurityInterceptor(leafMetadataSourceService(), leafAccessDecisionManager());
    }

    @Bean
    @ConditionalOnMissingBean
    public MyMetadataSourceService leafMetadataSourceService() {
        return new MyMetadataSourceService();
    }

    @Bean
    @ConditionalOnBean(MyFilterSecurityInterceptor.class)
    public FilterRegistrationBean disableSgFilterRegistration(
            MyFilterSecurityInterceptor myFilterSecurityInterceptor) {
        FilterRegistrationBean registration = new FilterRegistrationBean(myFilterSecurityInterceptor);
        registration.setEnabled(false);
        return registration;
    }

}
