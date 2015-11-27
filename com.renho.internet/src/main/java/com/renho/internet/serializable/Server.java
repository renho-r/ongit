package com.renho.internet.serializable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class Server {

	private Selector selector;
	
	private void init() {
		ServerSocketChannel ssc;
		try {
			ssc = ServerSocketChannel.open();
			ssc.configureBlocking(false);
			ssc.socket().bind(new InetSocketAddress(8080));
			
			selector = Selector.open();
			ssc.register(selector, SelectionKey.OP_ACCEPT);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void listen() throws IOException {
		while(true) {
			selector.select();
			Iterator<SelectionKey> it = selector.selectedKeys().iterator();
			while(it.hasNext()) {
				SelectionKey key = it.next();
				if(key.isAcceptable()) {
					ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
					SocketChannel sc = ssc.accept();
					write(sc);					
				}else if(key.isReadable()) {
					
				}
				it.remove();
			}
		}
	}
	
	private void write(SocketChannel sc) throws IOException {
		RandomAccessFile raf = new RandomAccessFile(new File("d:SerializableObject.object"), "r");
		FileChannel fc = raf.getChannel();
		ByteBuffer buf = ByteBuffer.allocate((int) raf.length());
		fc.read(buf);
		buf.flip();
		sc.write(buf);
		fc.close();
		raf.close();
	}
	
	private void writeObject() throws IOException {
		FileOutputStream fos = new FileOutputStream(new File("d:SerializableObject.object"));
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(so);
		oos.close();
	}
	
	private SerializableObject so = new SerializableObject(1, "renho");
	
	public static void main(String[] args) throws IOException {
		
		Server server = new Server();
		server.writeObject();
		server.init();
		server.listen();
	}

}
