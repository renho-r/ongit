package com.renho.nio.buffer;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ByteBufferTest {

	public static void main(String[] args) throws IOException {
		RandomAccessFile aFile = new RandomAccessFile("data/nio-data.txt", "rw");
		FileChannel inChannel = aFile.getChannel();

		ByteBuffer buf = ByteBuffer.allocate(48);

		int bytesRead = inChannel.read(buf);
		while(-1 != bytesRead) {
			System.out.println("----->start<-----");
			System.out.println("buf.position():" + buf.position());
			buf.flip();
			System.out.println("buf.position():" + buf.position());
			buf.position(10);
			System.out.println("buf.position():" + buf.position());
			
			System.out.println("buf" + buf);
			System.out.println("buf.array():" + buf.array());
			System.out.println("new String(buf.array()):" + new String(buf.array()));
			System.out.println("buf.capacity():" + buf.capacity());
			
			System.out.println("buf.limit():" + buf.limit());
			
			buf.clear();//不能实际清除
			
			bytesRead = inChannel.read(buf);
		}
		
		
		aFile.close();
	}

}
