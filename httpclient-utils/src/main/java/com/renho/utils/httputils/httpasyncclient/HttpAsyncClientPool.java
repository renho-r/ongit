package com.renho.utils.httputils.httpasyncclient;

import com.renho.utils.PropertiesUtils;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.impl.nio.conn.PoolingNHttpClientConnectionManager;
import org.apache.http.impl.nio.reactor.DefaultConnectingIOReactor;
import org.apache.http.nio.reactor.ConnectingIOReactor;
import org.apache.http.nio.reactor.IOReactorException;

/**
 * @auther: renho
 * @since: 1.0.0
 */
public class HttpAsyncClientPool {

    private static final String MAX_TOTAL = "10";
    private static final String DEFAULT_MAX_PER_ROUTE = "10";

    private static final String REQUEST_TIME = "3000";
    private static final String CONNECT_TIMEOUT = "5000";
    private static final String SOCKET_TIMEOUT = "5000";

    private static PoolingNHttpClientConnectionManager cm = null;
    private static RequestConfig globalConfig = null;

    static {

        ConnectingIOReactor ioReactor = null;
        try {
            ioReactor = new DefaultConnectingIOReactor();
            cm = new PoolingNHttpClientConnectionManager(ioReactor);
            cm.setMaxTotal(Integer.valueOf(PropertiesUtils.getProperty("async.max.total", MAX_TOTAL)));
            cm.setDefaultMaxPerRoute(Integer.valueOf(PropertiesUtils.getProperty("async.default.max.per.route", DEFAULT_MAX_PER_ROUTE)));

            globalConfig = RequestConfig.custom()
                    .setConnectionRequestTimeout(Integer.valueOf(PropertiesUtils.getProperty("async.request.timeout", REQUEST_TIME)))//设置从连接池获取可用连接超时
                    .setConnectTimeout(Integer.valueOf(PropertiesUtils.getProperty("async.connect.timeout", CONNECT_TIMEOUT)))//连接目标超时
                    .setSocketTimeout(Integer.valueOf(PropertiesUtils.getProperty("async.socket.timeout", SOCKET_TIMEOUT)))//读取数据超时
                    .build();

            IdleConnectionEvictor connEvictor = new IdleConnectionEvictor(cm);
            connEvictor.start();
        } catch (IOReactorException e) {
            e.printStackTrace();
        }
    }

    public static CloseableHttpAsyncClient getHttpClient() {
//        globalConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.IGNORE_COOKIES).build();
        CloseableHttpAsyncClient client = HttpAsyncClients.custom().setKeepAliveStrategy(new CustConnectionKeepAliveStrategy()).setConnectionManager(cm).setDefaultRequestConfig(globalConfig).build();
        return client;
    }

}

