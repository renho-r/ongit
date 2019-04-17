package com.renho.springcloud.reference.RefreshScope;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: renho
 * @since: 1.0.0
 */
@RefreshScope
@RestController
@SpringBootApplication
public class RefreshScopeApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(RefreshScopeApplication.class, args);
    }

    @Value("${refresh.scope.param}")
    private String param;

    @GetMapping("/param")
    public String param() {
        return this.param;
    }

}

// post http://localhost:54001/refresh
//修改target中配置文件