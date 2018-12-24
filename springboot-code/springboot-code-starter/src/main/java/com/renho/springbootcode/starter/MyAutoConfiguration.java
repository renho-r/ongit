package com.renho.springbootcode.starter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
@Configuration//开启配置
@EnableConfigurationProperties(MyStarterProperties.class)//开启使用映射实体对象
@ConditionalOnClass(MyStarterService.class)//存在MyStarterService时初始化该配置类
@ConditionalOnProperty//存在对应配置信息时初始化该配置类
        (
                prefix = "renho",//存在配置前缀renho
                value = "enabled",//开启
                matchIfMissing = true//缺失检查
        )
public class MyAutoConfiguration {

    @Bean
    public MyStarterService myStarterService() {
        return new MyStarterService();
    }
}
