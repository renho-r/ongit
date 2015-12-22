package com.renho.createfile;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CreateFile {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void create1gFile() throws IOException {
		String desFile = "h://lucene/catalina_1g.out";
		createFile(1, desFile);
	}
	
	@Test
	public void create1p5gFile() throws IOException {
		String desFile = "h://lucene/catalina_1p5g.out";
		createFile(1.5, desFile);
	}
	
	@Test
	public void create2gFile() throws IOException {
		String desFile = "h://lucene/catalina_2g.out";
		createFile(2, desFile);
	}
	
	private void createFile(double p, String desFile) throws IOException {
		String srcFile = "h://lucene/catalina.out";
		
		RandomAccessFile raf = new RandomAccessFile(srcFile, "r");
		RandomAccessFile rafw = new RandomAccessFile(desFile, "rw");
		
		FileChannel fc = raf.getChannel();
		FileChannel fcw = rafw.getChannel();
		
		ByteBuffer buf = ByteBuffer.allocate(1024);
		int count = (int) (1024 * 1024 * p);
		while(count > 0) {
			long len = fc.read(buf);	
			buf.flip();
			fcw.write(buf);
			
			buf.clear();
			fc.read(buf);
			count--;
		}
		raf.close();
		rafw.close();
	}

}
