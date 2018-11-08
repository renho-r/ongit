package com.renho.client.renho.pool;

import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

/**
 * @auther: renho
 * @since: 1.0.0
 */
public class HttpClientPool {

    public static PoolingHttpClientConnectionManager cm = null;

    static {
        cm = new PoolingHttpClientConnectionManager();
        cm.setMaxTotal(5);
        cm.setDefaultMaxPerRoute(5);
        IdleConnectionMonitorThread idleConnectionMonitorThread = new IdleConnectionMonitorThread(cm);
        idleConnectionMonitorThread.start();
    }

    public static CloseableHttpClient getHttpClient() {
        RequestConfig globalConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.IGNORE_COOKIES).build();
        CloseableHttpClient client = HttpClients.custom().setKeepAliveStrategy(new MyConnectionKeepAliveStrategy()).setConnectionManager(cm).setDefaultRequestConfig(globalConfig).build();
        return client;
    }

}

