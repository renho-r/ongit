package com.renho.beandefinitionregistrar.test.config;

import com.renho.beandefinitionregistrar.test.registrar.MapperAutoConfiguredMyBatisRegistrar;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
@Configuration
@Import(MapperAutoConfiguredMyBatisRegistrar.class)
public class BeanDefinitionRegistrarAutoConfiguration {
}
