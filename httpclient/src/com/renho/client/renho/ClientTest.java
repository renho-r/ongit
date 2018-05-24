package com.renho.client.renho;

import com.renho.client.renho.pool.HttpClientPool;
import com.renho.client.renho.task.HttpTask;
import org.apache.http.impl.client.CloseableHttpClient;

/**
 * @auther: renho
 * @since: 1.0.0
 */
public class ClientTest {

    public static void main(String[] args) throws InterruptedException {

        for(int i=0; i<100000; i++) {
            CloseableHttpClient httpClient = HttpClientPool.getHttpClient();
            Thread t = new Thread(new HttpTask(httpClient));
            t.start();
        }

        Thread.currentThread().join();
    }
}
