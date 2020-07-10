package com.renho.aware.test.ApplicationEventPublisherAware;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
@Component
public class ApplicationEventPublisherAwareMy implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        System.out.println("setApplicationEventPublisher");
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void publishEvent() {
        applicationEventPublisher.publishEvent(new MyEvent("renho"));
    }

}
