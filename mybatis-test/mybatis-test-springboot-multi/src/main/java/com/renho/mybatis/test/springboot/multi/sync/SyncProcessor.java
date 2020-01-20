package com.renho.mybatis.test.springboot.multi.sync;

import com.renho.mybatis.test.springboot.multi.domain.po.User;
import com.renho.mybatis.test.springboot.multi.service.IUserService;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * @author: renho
 * @since: 1.0.0
 */
@Slf4j
public class SyncProcessor implements Callable<String> {

    private BlockingQueue<User> users;
    private IUserService userService;
    private SyncServer syncServer;

    public SyncProcessor(BlockingQueue<User> users, IUserService userService, SyncServer syncServer) {
        this.users = users;
        this.userService = userService;
        this.syncServer = syncServer;
    }

    @Override
    public String call() {
        User user;
        while (true) {
            if (this.syncServer.isStop() && 0==this.users.size()) {
                break;
            }
            try {
                user = this.users.poll(10, TimeUnit.SECONDS);
                if (null != user) {
                    log.info(Thread.currentThread().getName() + ": sync user: " + user.getId());
                    user.setSynced(1);
                    this.userService.update(user);
                    TimeUnit.MILLISECONDS.sleep(500);
                }
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }
        return "success";
    }
}
