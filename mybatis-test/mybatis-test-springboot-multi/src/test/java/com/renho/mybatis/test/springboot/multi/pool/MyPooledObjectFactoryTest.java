package com.renho.mybatis.test.springboot.multi.pool;

import com.renho.mybatis.test.springboot.multi.domain.po.User;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: renho
 * @since: 1.0.0
 */
public class MyPooledObjectFactoryTest {

    @Test
    public void testPool() throws Exception {
        GenericObjectPoolConfig conf = new GenericObjectPoolConfig();
        conf.setMaxTotal(100);
        conf.setMaxIdle(100);
        GenericObjectPool<User> pool = new GenericObjectPool<User>(new UserPooledObjectFactory(), conf);
        ExecutorService executorService = Executors.newFixedThreadPool(17);
        List<MyTask> tasks = new ArrayList<>();
        for (int i=0; i<100; i++) {
            MyTask task = new MyTask(pool);
            tasks.add(task);
        }
        executorService.invokeAll(tasks);
        pool.listAllObjects().forEach(u -> {
            System.out.println("count: " + u.getBorrowedCount());
        });
        System.out.println(pool.listAllObjects().size());
    }

    public static class MyTask implements Callable<String> {

        private GenericObjectPool<User> pool;

        public MyTask(GenericObjectPool<User> pool) {
            this.pool = pool;
        }

        @Override
        public String call() throws Exception {
            User user = this.pool.borrowObject();
            user.request();
            this.pool.returnObject(user);
            return "success";
        }
    }
}
