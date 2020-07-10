package com.renho.springbootcode.conditional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
@Configuration
public class MyConditionalConfig {

    @Bean
    @Conditional(MyBeanCondition.class)
    //如果ManCondition中的match方法返回结果true，就创建该Bean,否则不创建
    public IMyBean getMyBean(){
        return new MyBeanImpl();
    }

}
