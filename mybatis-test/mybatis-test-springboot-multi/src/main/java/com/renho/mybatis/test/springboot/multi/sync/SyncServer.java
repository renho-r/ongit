package com.renho.mybatis.test.springboot.multi.sync;

import com.renho.mybatis.test.springboot.multi.config.MyConfig;
import com.renho.mybatis.test.springboot.multi.domain.po.User;
import com.renho.mybatis.test.springboot.multi.service.IUserService;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author: renho
 * @since: 1.0.0
 */
@Slf4j
public class SyncServer {

    private volatile boolean stop;
    private final BlockingQueue<User> USERS = new LinkedBlockingQueue();

    private IUserService userService;
    private MyConfig config;
    private volatile static boolean started;

    public SyncServer(IUserService userService, MyConfig config) {
        this.userService = userService;
        this.config = config;
    }

    public void start() {
        if (!SyncServer.started) {
            SyncServer.started = true;
            new Thread(() -> SyncServer.this.run()).start();
        } else {
            log.debug("ignore start");
        }
    }

    public void run() {
        log.info(Thread.currentThread().getName() + ": " + "SyncServer start ...");

        SyncProductor syncProductor = new SyncProductor(USERS, userService, this, config);
        new Thread(syncProductor).start();

        ThreadFactory myThreadFactory = new MyThreadFactory();

        ExecutorService executorService = new ThreadPoolExecutor(
                config.getWorker().getCount(),
                config.getWorker().getCount(),
                60L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue(config.getCache().getCount()),
                myThreadFactory);

        List<SyncProcessor> syncProcessors = new ArrayList<>();
        for (int i=0; i<config.getWorker().getCount(); i++) {
            syncProcessors.add(new SyncProcessor(USERS, this.userService, this));
        }

        try {
            executorService.invokeAll(syncProcessors);
            executorService.shutdown();
            SyncServer.started = false;
            log.info(Thread.currentThread().getName() + ": " + "SyncServer shutdown ...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isStop() {
        return stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }

    public class MyThreadFactory implements ThreadFactory {

        private int i = 0;
        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            t.setName("sync-processor-" + i++);
            return t;
        }
    }
}
