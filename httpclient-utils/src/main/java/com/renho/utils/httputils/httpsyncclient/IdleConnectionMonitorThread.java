package com.renho.utils.httputils.httpsyncclient;

import com.renho.utils.PropertiesUtils;
import org.apache.http.conn.HttpClientConnectionManager;

import java.util.concurrent.TimeUnit;

/**
 * @auther: renho
 * @since: 1.0.0
 */
public class IdleConnectionMonitorThread extends Thread {

    private static final String CLOSE_IDLE_CONNECTIONS= "30";
    private final HttpClientConnectionManager connMgr;
    private volatile boolean shutdown;

    public IdleConnectionMonitorThread(HttpClientConnectionManager connMgr) {
        super();
        this.connMgr = connMgr;
    }

    @Override
    public void run() {
        try {
            while (!shutdown) {
                synchronized (this) {
                    wait(5000);
                    // Close expired connections
                    connMgr.closeExpiredConnections();
                    // Optionally, close connections
                    // that have been idle longer than 30 sec
                    connMgr.closeIdleConnections(Integer.valueOf(PropertiesUtils.getProperty("sync.close.idle.connections", CLOSE_IDLE_CONNECTIONS)), TimeUnit.SECONDS);
                }
            }
        } catch (InterruptedException ex) {
            // terminate
        }
    }

    public void shutdown() {
        shutdown = true;
        synchronized (this) {
            notifyAll();
        }
    }

}