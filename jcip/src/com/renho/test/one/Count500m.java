package com.renho.test.one;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.*;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */

public class Count500m {

    public static class MyTask implements Callable<String> {

        private ConcurrentHashMap data = new ConcurrentHashMap();

        public MyTask(ConcurrentHashMap data) {
            this.data = data;
        }

        @Override
        public String call() throws Exception {
            for(int i=0; i<5000000; i++) {

//            }
//            while (this.data.size() < 10000000) {
                data.put(UUID.randomUUID().toString(), 15940088523L);
            }
            return null;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ConcurrentHashMap data = new ConcurrentHashMap(2<<32);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(9, 9, 30, TimeUnit.SECONDS, new LinkedBlockingQueue());
        List<Callable<String>> tasks = new ArrayList<>();
        for(int i=0; i<6; i++) {
            tasks.add(new MyTask(data));
        }
        long start = System.currentTimeMillis();
        executor.invokeAll(tasks);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

}
