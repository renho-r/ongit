package com.renho;

import com.renho.server.IEchoServer;

import java.io.IOException;
import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) throws IOException {

        ServiceLoader<IEchoServer> serviceLoader = ServiceLoader.load(IEchoServer.class);
        Iterator<IEchoServer> it = serviceLoader.iterator();
        while(it.hasNext()) {
            IEchoServer echoServer = it.next();
            echoServer.start(9999);
        }
        System.out.printf("start done ...\n");
    }
}
