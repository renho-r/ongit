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
        fileSyncConfig.setWorkerCount(5);

        return fileSyncConfig;
    }

}
