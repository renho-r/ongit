package com.renho.internet.nio.buffer;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ScatterGatherTest {

	public static void main(String[] args) throws IOException {
		
		RandomAccessFile raf = new RandomAccessFile("data/nio-data.txt", "rw");
		FileChannel fc = raf.getChannel();
		ByteBuffer header = ByteBuffer.allocate(24);
		ByteBuffer body   = ByteBuffer.allocate(1024);
		ByteBuffer[] bufferArray = { header, body };
		fc.read(bufferArray);
		System.out.println(new String(header.array()));
		System.out.println(new String(body.array()));
		raf.close();
	}
	
}
