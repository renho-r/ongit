package com.renho.morefile.createfile;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.Callable;

public class CreateFile implements Callable<String> {

	private String filePath = "D:\\testfile";
	private int c;
	
	public CreateFile(int c) {
		this.c = c;
	}
	
	@Override
	public String call() throws Exception {
		String fileDir = filePath + "/r" + c;
		File file = new File(fileDir);
		if(!file.exists()) {
			file.mkdirs();
		}
		file = new File(fileDir + "/renho.txt");
		FileChannel fc = new RandomAccessFile(file, "rw").getChannel();
		int wi;
		byte[] bs;
		ByteBuffer bb;
		int it = 2000000;
		while((it--)>0) {
			wi = (int) (Math.random()*1000);
			bs = (wi + "\n").getBytes("UTF-8");
			bb = ByteBuffer.allocate(bs.length);
			bb.put(bs);
			bb.flip();
			fc.write(bb);
		}
		fc.close();
		return null;
	}

}
