package com.renho;

import com.renho.config.FileSyncConfig;
import com.renho.util.FileSyncUtil;
import com.renho.worker.FileSyncRejectedExecutionHandler;
import com.renho.worker.FileSyncTask;
import com.renho.worker.FileSyncThreadFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author: renho
 * @since: 1.0.0
 */
public enum  FileClient {

    INSTANCE;

    private static boolean inited;
    private ExecutorService executor = null;
    private List<Future<String>> results;

    FileClient() {}

    public void init() {
        if (!inited) {
            synchronized (this) {
                if (!inited) {
                    System.out.printf("init \n");
                    FileSyncConfig fileSyncConfig = FileSyncUtil.initFileConfig();
                    ThreadFactory threadFactory = new FileSyncThreadFactory();
                    RejectedExecutionHandler rejectedExecutionHandler = new FileSyncRejectedExecutionHandler();
                    BlockingQueue queue = new LinkedBlockingQueue(fileSyncConfig.getWorkerCount());
                    executor = new ThreadPoolExecutor(fileSyncConfig.getWorkerCount(),
                            fileSyncConfig.getWorkerCount(),
                            0,
                            TimeUnit.SECONDS,
                            queue,
                            threadFactory,
                            rejectedExecutionHandler);
                    results = new ArrayList<>();
                    inited = true;
                }
            }
        }
    }

<<<<<<< HEAD
    public boolean isDone() {
        if (inited && 0==results.size()) {
            return true;
        }
        return false;
=======
    public boolean isRunning() {
        return null != executor;
    }

    public boolean isDone() {
        return inited && 0==results.size();
>>>>>>> 0b2d391269a86ea901c36d7bd84b871bd8513774
    }

    public void shutdown() {
        executor.shutdown();
    }

    public void upload(File uploadFile) {
        upload(Arrays.asList(uploadFile));
    }

    public void upload(List<File> uploadFiles) {
        List<Future<String>> results = new ArrayList<>();

        for (File file: uploadFiles) {
            Future<String> result = executor.submit(new FileSyncTask(file));
            results.add(result);
        }

        for (Future<String> future: results) {
            try {
                String result = future.get();
                System.out.printf("%s\n", result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();
    }
}
