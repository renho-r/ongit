package com.renho.utils.httputils.httpasyncclient;

import com.renho.utils.PropertiesUtils;
import org.apache.http.nio.conn.NHttpClientConnectionManager;

import java.util.concurrent.TimeUnit;

public class IdleConnectionEvictor extends Thread  {

    private static final String CLOSE_IDLE_CONNECTIONS= "30";
    private final NHttpClientConnectionManager connMgr;
    private volatile boolean shutdown;

    public IdleConnectionEvictor(NHttpClientConnectionManager connMgr) {
        super();
        this.connMgr = connMgr;
    }

    public void run() {
        try {
            while (!shutdown) {
                synchronized (this) {
                    wait(5000);
                    // Close expired connections
                    connMgr.closeExpiredConnections();
                    // Optionally, close connections
                    // that have been idle longer than 5 sec
                    connMgr.closeIdleConnections(Integer.valueOf(PropertiesUtils.getProperty("async.close.idle.connections", CLOSE_IDLE_CONNECTIONS)), TimeUnit.SECONDS);
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
