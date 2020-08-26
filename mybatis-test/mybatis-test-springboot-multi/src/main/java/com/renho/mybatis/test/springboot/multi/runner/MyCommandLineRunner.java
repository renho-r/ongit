package com.renho.mybatis.test.springboot.multi.runner;

import com.renho.mybatis.test.springboot.multi.config.MyConfig;
import com.renho.mybatis.test.springboot.multi.service.IUserService;
import com.renho.mybatis.test.springboot.multi.sync.SyncServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author: renho
 * @since: 1.0.0
 */
@Component
public class MyCommandLineRunner implements CommandLineRunner {

    @Autowired
    private IUserService userService;
    @Autowired
    private MyConfig myConfig;

    @Override
    public void run(String... args) {

        if (myConfig.isAlways()) {
            new SyncServer(userService, myConfig).start();
        }
    }
}
