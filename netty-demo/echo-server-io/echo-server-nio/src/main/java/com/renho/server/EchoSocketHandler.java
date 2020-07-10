package com.renho.server;

import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class EchoSocketHandler implements Runnable {

    private SocketChannel clientChannel;
    private boolean isOpen = false;

    public EchoSocketHandler() {}

    public EchoSocketHandler(SocketChannel clientChannel) {
        this.clientChannel = clientChannel;
        this.isOpen = true;
    }

    @Override
    public void run() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        try {
            while (isOpen) {
                byteBuffer.clear();
                int readCount = clientChannel.read(byteBuffer);
                String msg = new String(byteBuffer.array(), 0, readCount);
                String writeMsg = "[echo]" + msg;
                if ("bye".equalsIgnoreCase(msg)) {
                    this.isOpen = false;
                    break;
                }
                byteBuffer.clear();
                byteBuffer.put(writeMsg.getBytes());
                byteBuffer.flip();
                clientChannel.write(byteBuffer);
                ByteBuffer.allocateDirect(1024);
            }
            clientChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
