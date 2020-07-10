package com.renho.spring.extension.listener;

import com.renho.spring.util.LogUtil;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationListener implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println(event.getClass());
        LogUtil.logStack();
    }
}
