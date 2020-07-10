package com.renho.my.starter;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
@ConfigurationProperties(prefix = "renho")
public class MyStarterProperties {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
