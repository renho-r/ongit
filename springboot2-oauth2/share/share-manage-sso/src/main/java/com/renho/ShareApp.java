package com.renho;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@MapperScan("com.renho.share.mapper")
public class ShareApp  {
    public static void main( String[] args ) {
        SpringApplication.run(ShareApp.class, args);
    }
}
