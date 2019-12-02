package com.renho.zk.client;

import java.io.IOException;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class ClientCnxnRenho {

    private String url;
    private volatile LinkedList sendQueue = new LinkedList();
    SocketChannel clientChannel;
    Selector selector;

    public ClientCnxnRenho(String url) {
        this.url = url;
    }

    public void start() {
        try {
            startConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Thread t = new EventThread();
        t.setName("EventThread");
        t.start();
    }

    private void startConnection() throws IOException {
        SocketChannel sc = SocketChannel.open();
        sc.configureBlocking(false);
        sc.connect(new InetSocketAddress("localhost", 2181));
        selector = Selector.open();
        sc.register(selector, SelectionKey.OP_CONNECT);
    }

    class SendThread extends Thread {

        @Override
        public void run() {
            while (true) {
                if(sendQueue.size() > 0) {
                    System.out.printf("%s\n", sendQueue.size());
                    byte[] req = (byte[]) sendQueue.remove();
                    System.out.printf("send %s\n", req.length);
                    try {
                        clientChannel.write(ByteBuffer.wrap(req));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    class EventThread extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    selector.select();
                    System.out.printf("%s\n", "get a select");
                    Iterator it = selector.selectedKeys().iterator();
                    while (it.hasNext()) {
                        SelectionKey key = (SelectionKey) it.next();
                        System.out.printf("key: %s \n", key);
                        it.remove();
                        if(key.isConnectable()) {
                            System.out.printf("connectable\n");
                            clientChannel = (SocketChannel) key.channel();
                            if (clientChannel.isConnectionPending()) {
                                clientChannel.finishConnect();
                            }
                            clientChannel.configureBlocking(false);
                            clientChannel.register(selector, SelectionKey.OP_READ);

                            sendCreateSession();

                            Thread t = new SendThread();
                            t.setName("SendThread");
                            t.start();
                            t = new Ping();
                            t.setName("Ping");
                            t.start();

                        } else if (key.isReadable()) {
                            read(key);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        private void read(SelectionKey key) throws Exception {
            System.out.printf("%s\n", "read start ...");
            SocketChannel channel = (SocketChannel) key.channel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int len = channel.read(buffer);
            System.out.printf("read len: %s\n", len);
            if(-1 == len) {
                System.out.printf("channel close\n");
                channel.close();
                return;
            }
            byte[] data = buffer.array();
            String msg = new String(data).trim();
            System.out.println("client receive msg from server:" + msg);
            for (int i=0; i<data.length; i++) {
                System.out.printf("%s, ", data[i]);
            }
            System.out.println();
        }

        private void ruok() {
            sendQueue.push(new byte[] {114, 117, 111, 107});
        }

        private void sendCreateSession() {
//            sendQueue.add(new byte[]{0, 0, 0, 0});
            sendQueue.add(new byte[]{0, 0, 0, 45});
            sendQueue.add(new byte[]{/**/0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                          0, 0, 0, 0, 117, 48, 0, 0, 0, 0,
                                          0, 0, 0, 0, 0, 0, 0, 16, 0, 0,
                                          0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                          0, 0, 0, 0, 0});
            sendQueue.add(new byte[]{0, 0, 0, 8/**/, -1, -1, -1, -2, 0, 0, 0, 11});
        }
    }

    class Ping extends Thread {
        @Override
        public void run() {
            while (true) {
                sendQueue.add(new byte[]{0, 0, 0, 8/**/, -1, -1, -1, -2, 0, 0, 0, 11});
                System.out.printf("%s\n", "add ping ... ");
                try {
                    TimeUnit.SECONDS.sleep(new Random().nextInt(10));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
