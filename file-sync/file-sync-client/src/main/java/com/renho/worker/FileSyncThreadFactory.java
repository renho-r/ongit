package com.renho.worker;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: renho
 * @since: 1.0.0
 */
public class FileSyncThreadFactory implements ThreadFactory {

    private static AtomicInteger count = new AtomicInteger(0);

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setName("FileSyncThread-" + count.addAndGet(1));
        return t;
    }
}
