package com.renho.internet.nio.buffer;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileBufferTest {

	public static void main(String[] args) throws IOException {
		RandomAccessFile raf = new RandomAccessFile("data/nio-data.txt", "rwd");
		FileChannel fc = raf.getChannel();
		//×·¼ÓÐ´
		/*fc.position(fc.size());
		ByteBuffer buf = ByteBuffer.wrap("renho".getBytes());
		fc.write(buf);
		raf.close();*/
		/**
		 * capacity
		 * limit
		 * position
		 * rewind
		 * compact
		 */
		
		ByteBuffer buf = ByteBuffer.allocate(48);
		
		int count = fc.read(buf);
		while(-1 != count) {
			buf.flip();
			while(buf.hasRemaining()){
				System.out.print((char) buf.get());
			}
			buf.clear();
			count = fc.read(buf);
		}
		raf.close();
	}
	
}
