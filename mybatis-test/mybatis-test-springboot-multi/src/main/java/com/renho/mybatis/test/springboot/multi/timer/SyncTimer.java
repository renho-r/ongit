package com.renho.mybatis.test.springboot.multi.timer;

import com.renho.mybatis.test.springboot.multi.config.MyConfig;
import com.renho.mybatis.test.springboot.multi.service.IUserService;
import com.renho.mybatis.test.springboot.multi.sync.SyncServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: renho
 * @since: 1.0.0
 */
@Slf4j
public class SyncTimer {

    private IUserService userService;
    private MyConfig myConfig;

    public SyncTimer(IUserService userService, MyConfig myConfig) {
        this.userService = userService;
        this.myConfig = myConfig;
    }

    @Scheduled(cron = "${my.sync.sch: 0/1 * * * * ? }")
    public void sync() {
        log.debug("start @" + new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
        new SyncServer(this.userService, this.myConfig).start();
    }

}
