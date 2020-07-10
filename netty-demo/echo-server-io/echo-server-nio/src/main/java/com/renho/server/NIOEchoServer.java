package com.renho.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class NIOEchoServer implements IEchoServer {

    @Override
    public void start(int port) throws IOException {

        System.out.printf("start NIOEchoServer at %d \n", port);
        final AtomicInteger count = new AtomicInteger(0);
        final Executor executor = new ThreadPoolExecutor(2, 3, 60, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(1), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                t.setName("thread-" + count.getAndAdd(1));
                return t;
            }
        }, new ThreadPoolExecutor.AbortPolicy());
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress(port));
        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        int keySelect = 0;
        while ((keySelect=selector.select()) > 0) {
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> it = selectionKeys.iterator();
            while (it.hasNext()) {
                SelectionKey selectionKey = it.next();
                if (selectionKey.isAcceptable()) {
                    SocketChannel clientChannel = serverSocketChannel.accept();
                    Runnable task = new EchoSocketHandler(clientChannel);
                    executor.execute(task);
                }
                it.remove();
            }
        }
        ((ThreadPoolExecutor) executor).shutdown();
        serverSocketChannel.close();

    }

}
