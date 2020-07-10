package com.renho.aware.test.ApplicationEventPublisherAware;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
@Component
public class EventListener implements ApplicationListener<MyEvent> {

    @Override
    public void onApplicationEvent(MyEvent event) {
        System.out.println("EventListener");
    }

}
