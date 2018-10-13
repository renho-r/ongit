package com.renho.share.utils;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: renho
 * @since: 1.0.0
 */
@Component
@ConfigurationProperties(prefix="share") //接收application.yml中的myProps下面的属性
public class ShareProperties {

    private String basepath;

    public String getBasepath() {
        return basepath;
    }

    public void setBasepath(String basepath) {
        this.basepath = basepath;
    }
}
