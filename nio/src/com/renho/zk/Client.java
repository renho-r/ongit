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
                    selector.select(); // ���selector��ѡ�е���ĵ�����
                    Iterator ite = selector.selectedKeys().iterator();
                    while (ite.hasNext()) {
                        SelectionKey key = (SelectionKey) ite.next(); // ɾ����ѡ��key,�Է��ظ�����
                        ite.remove(); // �����¼�����
                        if (key.isConnectable()) {
                            SocketChannel channel = (SocketChannel) key.channel(); // ����������ӣ����������
                            if (channel.isConnectionPending()) {
                                channel.finishConnect();
                            } // ���óɷ�����
                            channel.configureBlocking(false);
                            // ��������Ը�����˷�����ϢŶ
                            channel.write(ByteBuffer.wrap(new byte[]{-1}));
                            channel.write(ByteBuffer.wrap(new byte[]{-1}));
                            channel.write(ByteBuffer.wrap(new byte[]{-1}));
                            channel.write(ByteBuffer.wrap(new byte[]{-2}));
                            channel.write(ByteBuffer.wrap(new byte[]{0}));
                            channel.write(ByteBuffer.wrap(new byte[]{0}));
                            channel.write(ByteBuffer.wrap(new byte[]{0}));
                            channel.write(ByteBuffer.wrap(new byte[]{11}));
                            // �ںͷ�������ӳɹ�֮��Ϊ�˿��Խ��յ�����˵���Ϣ����Ҫ��ͨ�����ö���Ȩ�ޡ�
                            channel.register(this.selector, SelectionKey.OP_READ); // ����˿ɶ����¼�
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
