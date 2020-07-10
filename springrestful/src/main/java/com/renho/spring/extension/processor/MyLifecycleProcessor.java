package com.renho.spring.extension.processor;

import com.renho.spring.util.LogUtil;
import org.springframework.context.LifecycleProcessor;
import org.springframework.stereotype.Component;

@Component("lifecycleProcessor")
public class MyLifecycleProcessor implements LifecycleProcessor {

    @Override
    public void onRefresh() {
        LogUtil.logStack();
    }

    @Override
    public void onClose() {
        LogUtil.logStack();
    }

    @Override
    public void start() {
        LogUtil.logStack();
    }

    @Override
    public void stop() {
        LogUtil.logStack();
    }

    @Override
    public boolean isRunning() {
        return false;
    }
}
