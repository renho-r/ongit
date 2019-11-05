package com.renho.worker;

import java.io.File;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * @author: renho
 * @since: 1.0.0
 */
public class FileSyncTask implements Callable<String> {

    private File file;

    public FileSyncTask(File file) {
        this.file = file;
    }

    @Override
    public String call() throws Exception {
        System.out.printf("sync file: %s\n", file.getName());
        TimeUnit.SECONDS.sleep(1);
        return "success";
    }
}
