package com.renho.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class ThreadPoolTest {

    public static void main(String[] args) throws InterruptedException {

        ThreadFactory threadFactory = new MyThreadFactory("MyThread");

//        fixedThreadPool(threadFactory);
//        singleThreadExecutor(threadFactory);
//        cacheThreadPool(threadFactory);
//        scheduledThreadPool(threadFactory);
//        linkedBlockingQueue(threadFactory);
//        synchronousQueue(threadFactory);
        arrayBlockingQueue(threadFactory);
    }

    private static void arrayBlockingQueue(ThreadFactory threadFactory) throws InterruptedException {
        ExecutorService executorService = new ThreadPoolExecutor(
                1,
                3,
                0L,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(1),
                threadFactory,
                new ThreadPoolExecutor.AbortPolicy());
        List<Callable<String>> tasks = makeTasks(5);
        executorService.invokeAll(tasks);
        executorService.shutdown();
    }

    private static void synchronousQueue(ThreadFactory threadFactory) throws InterruptedException {
        /*
            SynchronousQueue没有容量，是无缓冲等待队列，是一个不存储元素的阻塞队列，会直接将任务交给消费者，必须等队列中的添加元素被消费后才能继续添加新的元素。
         */
        ExecutorService executorService = new ThreadPoolExecutor(
                1,
                3,
                0L,
                TimeUnit.MILLISECONDS,
                new SynchronousQueue<Runnable>(),
                threadFactory,
                new ThreadPoolExecutor.AbortPolicy());
        List<Callable<String>> tasks = makeTasks(4);
        executorService.invokeAll(tasks);
        executorService.shutdown();
    }

    /**
     * AbortPolicy：如果线程池队列满了丢掉这个任务并且抛出RejectedExecutionException异常。
     * DiscardPolicy：如果线程池队列满了，会直接丢掉这个任务并且不会有任何异常。
     * DiscardOldestPolicy：丢弃最老的。也就是说如果队列满了，会将最早进入队列的任务删掉腾出空间，再尝试加入队列。
     * CallerRunsPolicy：如果添加到线程池失败，那么主线程会自己去执行该任务，不会等待线程池中的线程去执行。就像是个急脾气的人，我等不到别人来做这件事就干脆自己干。
     * @param threadFactory
     */
    /*
    BlockingQueue和ArrayBlockingQueue
    相同:
        1. 都实现了BlockingQueue接口
        2. 都是使用ReentrantLock和Condition来保证生产和消费的同步
        3. 都是可阻塞的队列
    区别：
        1. 锁不同
            LinkedBlockingQueue中的锁是分离的，生产者的锁PutLock，消费者的锁takeLock
            而ArrayBlockingQueue生产者和消费者使用的是同一把锁；
        2. 底层实现机制也不同
            LinkedBlockingQueue：链表
            ArrayBlockingQueue：数组
     */
    private static void linkedBlockingQueue(ThreadFactory threadFactory) throws InterruptedException {
        /*
        1.启动核心线程，剩余任务放入LinkedBlockingQueue，LinkedBlockingQueue满了后，启动除核心线程外线程，再剩余的按策略处理。
         */
        ExecutorService executorService = new ThreadPoolExecutor(
                1,
                3,
                0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1),
                threadFactory,
                new ThreadPoolExecutor.AbortPolicy());

//        ExecutorService executorService = new ThreadPoolExecutor(
//                1,
//                3,
//                0L,
//                TimeUnit.MILLISECONDS,
//                new LinkedBlockingQueue<Runnable>(1),
//                threadFactory,
//                new ThreadPoolExecutor.DiscardPolicy());

//        ExecutorService executorService = new ThreadPoolExecutor(
//                1,
//                3,
//                0L,
//                TimeUnit.MILLISECONDS,
//                new LinkedBlockingQueue<Runnable>(1),
//                threadFactory,
//                new ThreadPoolExecutor.DiscardOldestPolicy());
//        ExecutorService executorService = new ThreadPoolExecutor(
//                1,
//                3,
//                0L,
//                TimeUnit.MILLISECONDS,
//                new LinkedBlockingQueue<Runnable>(1),
//                threadFactory,
//                new ThreadPoolExecutor.CallerRunsPolicy());
        List<Callable<String>> tasks = makeTasks(4);
        executorService.invokeAll(tasks);
        executorService.shutdown();
    }

    private static void scheduledThreadPool(ThreadFactory threadFactory) throws InterruptedException {
        ExecutorService executorService = Executors.newScheduledThreadPool(10, threadFactory);
        ((ScheduledExecutorService) executorService).schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }, 10, TimeUnit.SECONDS);
        ((ScheduledExecutorService) executorService).schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }, 10, TimeUnit.SECONDS);
        executorService.shutdown();
    }

    private static void cacheThreadPool(ThreadFactory threadFactory) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool(threadFactory);
        List<Callable<String>> tasks = makeTasks(100);
        executorService.invokeAll(tasks);
        executorService.shutdown();
    }

    private static void singleThreadExecutor(ThreadFactory threadFactory) throws InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor(threadFactory);
        /*
        public static ExecutorService newSingleThreadExecutor(ThreadFactory threadFactory) {
        return new FinalizableDelegatedExecutorService
            (new ThreadPoolExecutor(1, 1,
                                    0L, TimeUnit.MILLISECONDS,
                                    new LinkedBlockingQueue<Runnable>(),
                                    threadFactory));
        }
         */
        List<Callable<String>> tasks = makeTasks(100);
        executorService.invokeAll(tasks);
        executorService.shutdown();
    }

    private static void fixedThreadPool(ThreadFactory threadFactory) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10, threadFactory);
        /*
        public static ExecutorService newFixedThreadPool(int nThreads, ThreadFactory threadFactory) {
        return new ThreadPoolExecutor(nThreads, nThreads,
                                      0L, TimeUnit.MILLISECONDS,
                                      new LinkedBlockingQueue<Runnable>(),
                                      threadFactory);
        }
         */

        List<Callable<String>> tasks = makeTasks(100);
        executorService.invokeAll(tasks);
        executorService.shutdown();
    }

    private static List<Callable<String>> makeTasks(int taskCount) {
        List<Callable<String>> tasks = new ArrayList<>();
        for(int i=0; i<taskCount; i++) {
            tasks.add(new MyTask(i));
        }
        return tasks;
    }

    public static class MyTask implements Callable<String> {

        private int id;

        public MyTask() {}

        public MyTask(int id) {
            this.id = id;
        }

        @Override
        public String call() throws Exception {
            System.out.println(Thread.currentThread().getName() + "-------->" + this.id);
            return null;
        }
    }

    public static class MyThreadFactory implements ThreadFactory {

        private String preName;

        public MyThreadFactory() {}

        public MyThreadFactory(String preName) {
            this.preName = preName;
        }

        private static AtomicInteger index = new AtomicInteger(0);

        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            thread.setName(preName + index.getAndAdd(1));
            return thread;
        }
    }
}
