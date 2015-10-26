package com.renho.nio.selector.renho;

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
	
	public void initServer(int port) throws IOException {
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		serverSocketChannel.configureBlocking(false);
		serverSocketChannel.socket().bind(new InetSocketAddress(port));
		this.selector = Selector.open();
		serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
//		serverSocketChannel.register(selector, SelectionKey.OP_CONNECT);
//		serverSocketChannel.register(selector, SelectionKey.OP_READ);
//		serverSocketChannel.register(selector, SelectionKey.OP_WRITE);
//		serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT|SelectionKey.OP_CONNECT|SelectionKey.OP_READ|SelectionKey.OP_WRITE);
	}
	
	public void listen() throws IOException {
		while(true) {
			selector.select();
			Iterator<SelectionKey> ite = this.selector.selectedKeys().iterator();
			while (ite.hasNext()) {
				System.out.println("ite.hasNext");
				SelectionKey key = ite.next();
				System.out.println("isAcceptable:" + key.isAcceptable());
				System.out.println("isConnectable:" + key.isConnectable());
				System.out.println("isReadable:" + key.isReadable());
				System.out.println("isWritable:" + key.isWritable());
				
				if(key.isAcceptable()) {
					System.out.println("---------------------------->isAcceptable<------------------------");
					ite.remove();
					ServerSocketChannel server = (ServerSocketChannel) key.channel();
					SocketChannel channel = server.accept();
					channel.configureBlocking(false);
					channel.register(selector, SelectionKey.OP_READ);
				}
				
				if(key.isReadable()) {
					System.out.println("---------------------------->isReadable<------------------------");
					SocketChannel channel = (SocketChannel) key.channel();
					ByteBuffer buffer = ByteBuffer.allocate(1024);
					channel.read(buffer);
					byte[] data = buffer.array();
					String msg = new String(data).trim();
					System.out.println("server receive from client: " + msg);
					ByteBuffer outBuffer = ByteBuffer.wrap("receive ok".getBytes());
					channel.write(outBuffer);
				}
				
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		NioServer nioServer = new NioServer();
		nioServer.initServer(8080);
		nioServer.listen();
	}

}
