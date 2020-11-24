package com.renho.springbootcode.listener;

import com.renho.springbootcode.util.LogUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author renho
 * @date 2020/11/24
 */
public class MySpringApplicationRunListener implements SpringApplicationRunListener {

    private final SpringApplication application;
    private final String[] args;

    public MySpringApplicationRunListener(SpringApplication application, String[] args) {
        this.application = application;
        this.args = args;
    }

    @Override
    public void starting() {
        System.out.println(LogUtil.PRE + "starting" + LogUtil.SUF);
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        LogUtil.mark("environmentPrepared");
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        LogUtil.mark("contextPrepared");
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        LogUtil.mark("contextLoaded");
    }

    @Override
    public void started(ConfigurableApplicationContext context) {
        LogUtil.mark("started");
    }

    @Override
    public void running(ConfigurableApplicationContext context) {
        LogUtil.mark("running");
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        LogUtil.mark("failed");
    }
}
