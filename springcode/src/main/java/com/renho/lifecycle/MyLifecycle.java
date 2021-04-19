package com.renho.lifecycle;

import org.springframework.context.Lifecycle;
import org.springframework.context.SmartLifecycle;

/**
 * @author renho
 * @date 2021/4/19
 */
public class MyLifecycle implements SmartLifecycle {

    private static Boolean isRunning = false;

    @Override
    public void start() {
        System.out.println("MyLifecycle.start");
        isRunning = true;
    }

    @Override
    public void stop() {
        System.out.println("MyLifecycle.stop");
    }

    @Override
    public boolean isRunning() {
        System.out.println("MyLifecycle.isRunning");
        return isRunning;
    }

    @Override
    public boolean isAutoStartup() {
        System.out.println("MyLifecycle.isAutoStartup");
        return true;
    }

    @Override
    public void stop(Runnable callback) {
        System.out.println("MyLifecycle.stop.callback");
    }

    @Override
    public int getPhase() {
        return 0;
    }
}
