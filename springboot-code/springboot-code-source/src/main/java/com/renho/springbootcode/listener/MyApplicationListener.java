package com.renho.springbootcode.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.GenericApplicationListener;
import org.springframework.core.ResolvableType;

/**
 * @author: renho
 * @since: 1.0.0
 */
//public class MyApplicationListener implements ApplicationListener<ApplicationEvent> {
public class MyApplicationListener implements GenericApplicationListener {


    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("MyApplicationListener onApplicationEvent: " + event);
    }

    /**
     * 判断是否处理事件类型
     * @param eventType
     * @return
     */
    @Override
    public boolean supportsEventType(ResolvableType eventType) {
        //class org.springframework.boot.context.event.ApplicationStartingEvent
        return true;
    }

    /**
     * 判断是否处理事件类型
     * @param sourceType
     * @return
     */
    @Override
    public boolean supportsSourceType(Class<?> sourceType) {
        //class org.springframework.boot.SpringApplication
        return true;
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
