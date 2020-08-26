package com.renho.config;

/**
 * @author: renho
 * @since: 1.0.0
 */
public class FileSyncConfig {

    private int workerCount;

    public FileSyncConfig() {}

    public int getWorkerCount() {
        return workerCount;
    }

    public void setWorkerCount(int workerCount) {
        this.workerCount = workerCount;
    }
}
