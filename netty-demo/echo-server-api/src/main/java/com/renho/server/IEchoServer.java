package com.renho.server;

import java.io.IOException;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public interface IEchoServer {

    void start(int port) throws IOException, InterruptedException;

}
