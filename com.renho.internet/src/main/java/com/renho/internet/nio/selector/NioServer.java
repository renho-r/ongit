package com.renho.internet.nio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class NioServer {
	
	private Selector selector;
	
	public void init() throws IOException {
		ServerSocketChannel ssc = ServerSocketChannel.open();
		ssc.configureBlocking(false);
		ssc.socket().bind(new InetSocketAddress(8080));
		
		selector = Selector.open();
		ssc.register(selector, SelectionKey.OP_ACCEPT);
	}
	
	public void listen() throws IOException {
		while(true) {
			selector.select();
			Iterator<SelectionKey> it = selector.selectedKeys().iterator();
			while(it.hasNext()) {
				SelectionKey key = it.next();
				if(key.isAcceptable()) {
					ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
					SocketChannel sc = ssc.accept();
					sc.configureBlocking(false);
					ByteBuffer buf = ByteBuffer.allocate(1024);
					buf.put("renho".getBytes());
					
					System.out.println(buf.capacity() + ":" + buf.limit() + ":" + buf.position());
					buf.flip();
					System.out.println(buf.capacity() + ":" + buf.limit() + ":" + buf.position());
					
					sc.write(buf);
					sc.register(selector, SelectionKey.OP_READ);
				} else if(key.isReadable()) {
					read(key);
				}
				it.remove();
			}
		}
	}
	
	private void read(SelectionKey key) throws IOException {
		SocketChannel sc = (SocketChannel) key.channel();
		ByteBuffer buf = ByteBuffer.allocate(1024);
		int count = sc.read(buf);
		while(count > 0) {
			buf.flip();
			System.out.println(new String(buf.array()));
			buf.clear();
			count = sc.read(buf);
		}
	}

	public static void main(String[] args) throws IOException {
		NioServer ns = new NioServer();
		ns.init();
		ns.listen();
	}
}