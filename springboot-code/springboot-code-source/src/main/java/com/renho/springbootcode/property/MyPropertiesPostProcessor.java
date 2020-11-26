package com.renho.springbootcode.property;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;

import java.util.Properties;

/**
 * @author renho
 * @date 2020/11/26
 */
public class MyPropertiesPostProcessor implements EnvironmentPostProcessor,  ApplicationContextInitializer {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        Properties properties = new Properties();
        properties.setProperty("my-renho-propertiy", "hh");
        PropertySource myPs = new MyPropertySource("myproperties", properties);
        ConfigurableEnvironment configurableEnvironment = applicationContext.getEnvironment();
        MutablePropertySources propertySources = configurableEnvironment.getPropertySources();
        propertySources.addLast(myPs);
    }

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        application.addInitializers(this);
    }

    private class MyPropertySource extends PropertiesPropertySource {

        public MyPropertySource(String name, Properties source) {
            super(name, source);
        }
    }
}
