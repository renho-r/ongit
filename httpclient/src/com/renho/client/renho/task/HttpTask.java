package com.renho.client.renho.task;

import com.renho.client.renho.pool.HttpClientPool;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.pool.PoolStats;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @auther: renho
 * @since: 1.0.0
 */
public class HttpTask implements Runnable {

    private final CloseableHttpClient httpClient;
    private final HttpContext context;

    public HttpTask(CloseableHttpClient httpClient) {
        this.httpClient = httpClient;
        this.context = HttpClientContext.create();
    }

    public void run() {
        try {
            PoolStats poolStats = HttpClientPool.cm.getTotalStats();
            System.out.printf("max: %s|available: %s|leased: %s|pending: %s\n", poolStats.getMax(), poolStats.getAvailable(), poolStats.getLeased(), poolStats.getPending());

            HttpPost httpPost = new HttpPost();
            try {
                httpPost.setURI(new URI("http://127.0.0.1:9090/api/http/auth/log"));
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }

            StringEntity stringEntity = null;
            try {
                stringEntity = new StringEntity("123");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            httpPost.setEntity(stringEntity);
            CloseableHttpResponse response = httpClient.execute(httpPost, context);
            try {
                HttpEntity entity = response.getEntity();
//                EntityUtils
                EntityUtils.consume(entity);
                entity.getContent().close();
            } finally {
                response.close();
            }
        } catch (ClientProtocolException ex) {
            // Handle protocol errors
        } catch (IOException ex) {
            // Handle I/O errors
        }
    }

}
