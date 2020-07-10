package com.renho.zk.client;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class ZkClientTest {

    @Test
    public void testInit() throws IOException {
        ZkClient zkClient = new ZkClient("localhost:2181", 3000);
        System.in.read();
    }

}
