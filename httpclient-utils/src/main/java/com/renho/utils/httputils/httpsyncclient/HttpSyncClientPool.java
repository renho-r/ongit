package com.renho.utils.httputils.httpsyncclient;

import com.renho.utils.PropertiesUtils;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

/**
 * @auther: renho
 * @since: 1.0.0
 */
public class HttpSyncClientPool {

    private static final String MAX_TOTAL = "10";
    private static final String DEFAULT_MAX_PER_ROUTE = "10";

    private static final String REQUEST_TIME = "3000";
    private static final String CONNECT_TIMEOUT = "5000";
    private static final String SOCKET_TIMEOUT = "5000";

    private static PoolingHttpClientConnectionManager cm = null;
    private static RequestConfig globalConfig = null;

    static {

        cm = new PoolingHttpClientConnectionManager();
        cm.setMaxTotal(Integer.valueOf(PropertiesUtils.getProperty("sync.max.total", MAX_TOTAL)));
        cm.setDefaultMaxPerRoute(Integer.valueOf(PropertiesUtils.getProperty("sync.default.max.per.route", DEFAULT_MAX_PER_ROUTE)));

        globalConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(Integer.valueOf(PropertiesUtils.getProperty("sync.request.timeout", REQUEST_TIME)))//设置从连接池获取可用连接超时
                .setConnectTimeout(Integer.valueOf(PropertiesUtils.getProperty("sync.connect.timeout", CONNECT_TIMEOUT)))//连接目标超时
                .setSocketTimeout(Integer.valueOf(PropertiesUtils.getProperty("sync.socket.timeout", SOCKET_TIMEOUT)))//读取数据超时
                .build();

        IdleConnectionMonitorThread idleConnectionMonitorThread = new IdleConnectionMonitorThread(cm);
        idleConnectionMonitorThread.start();
    }

    public static CloseableHttpClient getHttpClient() {
//        globalConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.IGNORE_COOKIES).build();
        CloseableHttpClient client = HttpClients.custom().setKeepAliveStrategy(new CustConnectionKeepAliveStrategy()).setConnectionManager(cm).setDefaultRequestConfig(globalConfig).build();
        return client;
    }

    public static RequestConfig getGlobalConfig() {
        return globalConfig;
    }
}

