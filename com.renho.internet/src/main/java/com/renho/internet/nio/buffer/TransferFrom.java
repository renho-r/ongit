package com.renho.internet.nio.buffer;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class TransferFrom {

	public static void main(String[] args) throws IOException {
		RandomAccessFile fromFile = new RandomAccessFile("data/nio-data.txt", "rw");
		FileChannel fromChannel = fromFile.getChannel();

		RandomAccessFile toFile = new RandomAccessFile("data/to_nio-data.txt", "rw");
		FileChannel toChannel = toFile.getChannel();

		long position = 0;
		long count = fromChannel.size();

//		toChannel.transferFrom(fromChannel, position, count);
//		toChannel.position(toChannel.size());
		fromChannel.transferTo(position, count, toChannel);
		
		fromFile.close();
		toFile.close();
	}

}
