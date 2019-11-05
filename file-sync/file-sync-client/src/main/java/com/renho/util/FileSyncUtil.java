package com.renho.util;

import com.renho.config.FileSyncConfig;

import java.util.concurrent.TimeUnit;

/**
 * @author: renho
 * @since: 1.0.0
 */
public class FileSyncUtil {

    public static FileSyncConfig initFileConfig() {

        FileSyncConfig fileSyncConfig = new FileSyncConfig();
        fileSyncConfig.setCorePoolSize(1);
        fileSyncConfig.setMaximumPoolSize(5);
        fileSyncConfig.setKeepAliveTime(120);
        fileSyncConfig.setUnit(TimeUnit.SECONDS);
        fileSyncConfig.setWorkerCount(200);

        return fileSyncConfig;
    }

}
