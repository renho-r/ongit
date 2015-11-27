package com.renho.internet.serializable;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class Client {

	private static byte[] objectByte = null;
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		SocketChannel sc = SocketChannel.open();
		Selector selector = Selector.open();
		sc.configureBlocking(false);
		sc.connect(new InetSocketAddress("localhost", 8080));
		sc.register(selector, SelectionKey.OP_CONNECT);
		
		while(true) {
			selector.select();
			Iterator<SelectionKey> it = selector.selectedKeys().iterator();
			while(it.hasNext()) {
				SelectionKey key = it.next();
				if(key.isConnectable()) {
					SocketChannel tsc = (SocketChannel) key.channel();
					if(tsc.isConnectionPending()) {
						tsc.finishConnect();						
					}
					tsc.configureBlocking(false);
					tsc.register(selector, SelectionKey.OP_READ);
				}else if(key.isReadable()) {
					SocketChannel tsc = (SocketChannel) key.channel();
					ByteBuffer buf = ByteBuffer.allocate(1024);
					int count = tsc.read(buf);
					if(count > 0) {
						objectByte = buf.array();
						readObject();
					}
				}
				it.remove();
			}
		}
	}

	private static void readObject() throws IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(objectByte));
		Object object = ois.readObject();
		SerializableObject so = (SerializableObject) object;
		System.out.println(so.getId() + ":" + so.getName());
	}

}
