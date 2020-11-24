package com.renho.springbootcode.initializer;

import com.renho.springbootcode.util.LogUtil;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * @author renho
 * @date 2020/11/24
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
public class MyApplicationContextInitializer implements ApplicationContextInitializer {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println(LogUtil.PRE + "MyApplicationContextInitializer.initialize" + LogUtil.SUF);
    }
}
