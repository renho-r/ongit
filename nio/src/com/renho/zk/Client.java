package com.renho.zk;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class Client {

    private SelectorThread selectorThread;

    public void init(String hostname, int port) throws IOException {
        SocketChannel sc = SocketChannel.open();
        sc.configureBlocking(false);
        this.selectorThread = new SelectorThread();
        sc.connect(new InetSocketAddress(hostname, port));
        sc.register(selectorThread.selector, SelectionKey.OP_CONNECT);
    }

    private void start() {
        selectorThread.start();
    }

    public static void main(String[] args) throws Exception {
        Client client = new Client();
        client.init("localhost", 2181);
        client.start();
    }

    class SelectorThread extends Thread {

        Selector selector;

        public SelectorThread()  {
            try {
                this.selector = Selector.open();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            while (true) {
                try {
                    selector.select(); // 获得selector中选中的项的迭代器
                    Iterator ite = selector.selectedKeys().iterator();
                    while (ite.hasNext()) {
                        SelectionKey key = (SelectionKey) ite.next(); // 删除已选的key,以防重复处理
                        ite.remove(); // 连接事件发生
                        if (key.isConnectable()) {
                            SocketChannel channel = (SocketChannel) key.channel(); // 如果正在连接，则完成连接
                            if (channel.isConnectionPending()) {
                                channel.finishConnect();
                            } // 设置成非阻塞
                            channel.configureBlocking(false);
                            // 在这里可以给服务端发送信息哦
                            channel.write(ByteBuffer.wrap(new byte[]{-1}));
                            channel.write(ByteBuffer.wrap(new byte[]{-1}));
                            channel.write(ByteBuffer.wrap(new byte[]{-1}));
                            channel.write(ByteBuffer.wrap(new byte[]{-2}));
                            channel.write(ByteBuffer.wrap(new byte[]{0}));
                            channel.write(ByteBuffer.wrap(new byte[]{0}));
                            channel.write(ByteBuffer.wrap(new byte[]{0}));
                            channel.write(ByteBuffer.wrap(new byte[]{11}));
                            // 在和服务端连接成功之后，为了可以接收到服务端的信息，需要给通道设置读的权限。
                            channel.register(this.selector, SelectionKey.OP_READ); // 获得了可读的事件
                        } else if (key.isReadable()) {
                            read(key);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }


        private void read(SelectionKey key) throws Exception {
            SocketChannel channel = (SocketChannel) key.channel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int len = channel.read(buffer);
            if(-1 == len) {
                channel.close();
                return;
            }
            byte[] data = buffer.array();
            String msg = new String(data).trim();
            System.out.println("client receive msg from server:" + msg);
            ByteBuffer outBuffer = ByteBuffer.wrap(msg.getBytes());
//            channel.write(outBuffer);
        }
    }

}
