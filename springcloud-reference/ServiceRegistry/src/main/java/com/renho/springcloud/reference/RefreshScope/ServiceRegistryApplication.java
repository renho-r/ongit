package com.renho.springcloud.reference.RefreshScope;
import com.renho.springcloud.reference.RefreshScope.config.MyConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author: renho
 * @since: 1.0.0
 */
@SpringBootApplication
public class ServiceRegistryApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ServiceRegistryApplication.class, args);
//        MyConfiguration myConfiguration = (MyConfiguration) context.getBean("myConfiguration");
//        myConfiguration.register();
    }

}