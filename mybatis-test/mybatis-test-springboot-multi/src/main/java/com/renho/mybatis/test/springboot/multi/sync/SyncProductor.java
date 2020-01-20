package com.renho.mybatis.test.springboot.multi.sync;

import com.renho.mybatis.test.springboot.multi.config.MyConfig;
import com.renho.mybatis.test.springboot.multi.domain.po.User;
import com.renho.mybatis.test.springboot.multi.service.IUserService;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author: renho
 * @since: 1.0.0
 */
@Slf4j
public class SyncProductor implements Runnable {

    private BlockingQueue<User> users;
    private IUserService userService;
    private SyncServer syncServer;
    private MyConfig config;

    public SyncProductor(BlockingQueue<User> users, IUserService userService, SyncServer syncServer, MyConfig config) {
        this.users = users;
        this.userService = userService;
        this.syncServer = syncServer;
        this.config = config;
    }

    /**
     * this.users.size()==0时SyncProcessor未更新到数据库，处理重复
     */
    @Override
    public void run() {
        int sleepTimes = 0;
        while (true) {
            try {
                if (this.users.size() <= config.getCache().getThreshold()) {
                    log.debug(Thread.currentThread().getName() + ": " + "pull user");
                    List<User> tmpUsers = this.userService.list(config.getCache().getCount());
                    if (tmpUsers.isEmpty()) {
                        try {
                            sleepTimes++;
                            if (!this.config.isAlways() && sleepTimes>=config.getSleepTimes()) {
                                break;
                            }
                            log.debug(Thread.currentThread().getName() + ": " + "sleep product 3s ...");
                            TimeUnit.SECONDS.sleep(3);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        log.info(Thread.currentThread().getName() + ": " + "cache user count: " + tmpUsers.size());
                        this.users.addAll(tmpUsers);
                        sleepTimes = 0;
                    }
                }
            } catch (Exception e) {
                log.error(e.getMessage());
            } finally { }
        }
        this.syncServer.setStop(true);
    }
}
