package com.renho.thread;

import java.util.concurrent.ThreadFactory;

/**
 * @author: renho
 * @since: 1.0.0
 */
public class MyThreadFactory implements ThreadFactory {

    private static Integer COUNT = 0;

    @Override
    public Thread newThread(Runnable r) {

        Thread t = new Thread(r);
        t.setName("MyThread-" + COUNT++);

        return t;
    }
}
