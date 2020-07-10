package com.renho.test.one;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Predicate;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class GuardedObject<T>{
    // 受保护的对象
    T obj;
    final Lock lock =
            new ReentrantLock();
    final Condition done =
            lock.newCondition();
    final int timeout=1;
    // 获取受保护对象
    public T get(Predicate<T> p) {
        lock.lock();
        try {
            //MESA 管程推荐写法
            while(!p.test(obj)){
                done.await(timeout,
                        TimeUnit.SECONDS);
            }
        }catch(InterruptedException e){
            throw new RuntimeException(e);
        }finally{
            lock.unlock();
        }
        // 返回非空的受保护对象
        System.out.println("return");
        return obj;
    }
    // 事件通知方法
    public void onChanged(T obj) throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        lock.lock();
        try {
            this.obj = obj;
            done.signalAll();
        } finally {
            lock.unlock();
        }
        System.out.println("signalAll");
    }

    public static void main(String[] args) throws InterruptedException {

        GuardedObject guardedObject = new GuardedObject();
//        new Thread(() -> guardedObject.get(t -> t != null)).start();
//
//        new Thread(() -> {
//            try {
//                guardedObject.onChanged(new Object());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();

        CompletableFuture.runAsync(() -> guardedObject.get(t -> t != null));
        CompletableFuture.runAsync(() -> {
            try {
                guardedObject.onChanged(new Object());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).whenComplete((a, b) -> {System.out.println(b.getMessage());});
        TimeUnit.SECONDS.sleep(5);
    }
}
