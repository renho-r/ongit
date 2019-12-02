package com.renho.zk.client;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class ZkClient {

    private String url;
    private int timeout;

    public ZkClient(String url, int timeout) {

        this.url = url;
        this.timeout = timeout;

        ClientCnxnRenho clientCnxn = new ClientCnxnRenho(url);
        clientCnxn.start();
    }
}
