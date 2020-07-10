package com.renho.lock;

<<<<<<< HEAD
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author renho
 * @since: 2019/10/31
 */
public class ReentrantLockTest {
    public static void main(String[] args) throws InterruptedException {

        ReentrantLock lock = new ReentrantLock(true);
        lock.lock();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                System.out.printf("%s: lock", Thread.currentThread().getName());
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();
            }
        });
        t.setName("other-thread");
        t.start();
        TimeUnit.SECONDS.sleep(3);
        lock.unlock();
=======
/**
 * @author: renho
 * @since: 1.0.0
 */
public class ReentrantLockTest {

    public static void main(String[] args) {

>>>>>>> 6997397a7f75bd3e5b9ef0dcf835840fff208b23
    }

}
