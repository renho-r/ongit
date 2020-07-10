package com.renho.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class BIOEchoServer implements IEchoServer {

    @Override
    public void start(int port) throws IOException {

        System.out.printf("start BIOEchoServer at %d \n", port);
        final AtomicInteger count = new AtomicInteger(0);
        final Executor executor = new ThreadPoolExecutor(2, 3, 60, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(1), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                t.setName("thread-" + count.getAndAdd(1));
                return t;
            }
        }, new ThreadPoolExecutor.AbortPolicy());

        final ServerSocket serverSocket = new ServerSocket(port);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        final Socket finalSocket = serverSocket.accept();
                        System.out.printf("%s: connected \n", Thread.currentThread().getName());
                        EchoSocketHandler echoSocketHandler = new EchoSocketHandler(finalSocket);
                        executor.execute(echoSocketHandler);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        System.out.printf("BIO exception: " + e.getMessage());
                    }
                }
            }
        };

        executor.execute(runnable);

    }
}
