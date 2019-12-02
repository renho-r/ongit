package com.renho.springbootzk.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
@Component("applicationContextHelper")
public class ApplicationContextHelper implements ApplicationContextAware {

    private static ApplicationContext ac;

    public static ApplicationContext getAc() {
        return ac;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationContextHelper.ac = applicationContext;
        ZooKeeperSession.init();

        ZooKeeperSession.getInstance().acquireDistributedLock(10000L);
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ZooKeeperSession.getInstance().releaseDistributedLock(10000L);
    }
}
