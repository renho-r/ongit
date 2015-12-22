package com.renho.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RandomAccessFileTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	String filePath = "h://javaIoTest/";
	String fileName = "randomAccessFile.txt";
	
	@Test
	public void writeTest() throws IOException {
		File file = new File(filePath, fileName);
		RandomAccessFile raf = new RandomAccessFile(file, "rw");
		getFilePointer(raf);
		//write byte[]
		byte[] bytes = "中文".getBytes();
		raf.write(bytes);
		getFilePointer(raf);
		raf.write(65);
		getFilePointer(raf);
		raf.write(66);
		getFilePointer(raf);
		raf.write(67);
		getFilePointer(raf);
		raf.write(68);
		getFilePointer(raf);
		raf.write("字母之后".getBytes());
		
		raf.seek(6);
		getFilePointer(raf);
		raf.write("插入".getBytes());//replace 4 byte
		getFilePointer(raf);
		raf.close();
	}
	
//	@Test
	public void readTest() throws IOException {
		File file = new File(filePath, fileName);
		RandomAccessFile raf = new RandomAccessFile(file, "rw");
		getFilePointer(raf);
		
		//read byte[]
		byte[] bytes = new byte[4];
		raf.read(bytes);
		getFilePointer(raf);
		System.out.println(new String(bytes));
		
		int intValue = raf.read();
		getFilePointer(raf);
		System.out.println(intValue);
		intValue = raf.read();
		getFilePointer(raf);
		System.out.println(intValue);
		intValue = raf.read();
		getFilePointer(raf);
		System.out.println(intValue);
		intValue = raf.read();
		getFilePointer(raf);
		System.out.println(intValue);
		
		bytes = new byte[2];
		raf.seek(2);
		getFilePointer(raf);
		int count = raf.read(bytes);
		System.out.println(new String(bytes));
		getFilePointer(raf);
		
		raf.close();
	}
	
	private long getFilePointer(RandomAccessFile raf) throws IOException {
		long lo = raf.getFilePointer();
		System.out.println("当前偏移量:" + lo);
		return lo;
	}

}
