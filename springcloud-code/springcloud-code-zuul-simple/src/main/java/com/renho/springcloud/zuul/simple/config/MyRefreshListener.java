package com.renho.springcloud.zuul.simple.config;

import org.springframework.cloud.client.discovery.event.HeartbeatEvent;
import org.springframework.cloud.client.discovery.event.InstanceRegisteredEvent;
import org.springframework.cloud.client.discovery.event.ParentHeartbeatEvent;
import org.springframework.cloud.context.scope.refresh.RefreshScopeRefreshedEvent;
import org.springframework.cloud.netflix.zuul.RoutesRefreshedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * @author: renho
 * @since: 1.0.0
 */
public class MyRefreshListener implements ApplicationListener<ApplicationEvent> {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof ContextRefreshedEvent
                || event instanceof RefreshScopeRefreshedEvent
                || event instanceof RoutesRefreshedEvent
                || event instanceof InstanceRegisteredEvent) {
            System.out.printf("get event[%s][reset]\n", event);
        }
        else if (event instanceof ParentHeartbeatEvent) {
            ParentHeartbeatEvent e = (ParentHeartbeatEvent) event;
            System.out.printf("get event[%s][resetIfNeeded]\n", event);
        }
        else if (event instanceof HeartbeatEvent) {
            HeartbeatEvent e = (HeartbeatEvent) event;
            System.out.printf("get event[%s][resetIfNeeded]\n", event);
        }
    }

}
