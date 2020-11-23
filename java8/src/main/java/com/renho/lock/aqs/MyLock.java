package com.renho.lock.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author: renho
 * @since: 1.0.0
 */
public class MyLock implements Lock {

    private MyAQS aqs = new MyAQS();

    @Override
    public void lock() {
        aqs.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {

    }

    @Override
    public Condition newCondition() {
        return null;
    }

    class MyAQS extends AbstractQueuedSynchronizer {

        @Override
        protected boolean tryAcquire(int arg) {
            compareAndSetState(0, 1);
            return arg != getState();
        }
    }
}
