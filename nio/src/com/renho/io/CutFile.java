package com.renho.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CutFile {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	String filePath = "h://javaIoTest/";
	String fileName = "catalina.out";
	long fileLen = 1024 * 1024 * 200;
	
	@Test
	public void test() throws InterruptedException, IOException {
		
		ExecutorService executor = Executors.newFixedThreadPool(10);
		List<Callable<String>> tasks = new ArrayList<Callable<String>>();
		RandomAccessFile raf = new RandomAccessFile(new File(filePath + fileName), "rw");
		long lenght = raf.length();
		int count = (int) Math.ceil((double)lenght/fileLen);
		raf.close();
		System.out.println(count);
		for(int i=0; i<count; i++) {
			Callable<String> task = new FileHandler(filePath + "cutFile/" + "catalina.out" + i, i * fileLen);
			tasks.add(task);
		}
		executor.invokeAll(tasks);
		executor.shutdown();
	}

	class FileHandler implements Callable<String>{
		String filePath = "h://javaIoTest/";
		String fileName = "catalina.out";
		
		long seekPoint = 0;
		String desFilePath;
		
		public FileHandler(String desFilePath, long seekPoint) {
			this.desFilePath = desFilePath;
			this.seekPoint = seekPoint;
		}
		
		@Override
		public String call() throws Exception {
			
			RandomAccessFile raf = new RandomAccessFile(new File(filePath + fileName), "rw");
			RandomAccessFile rafw = new RandomAccessFile(new File(desFilePath), "rw");
			raf.seek(seekPoint);
			byte[] bytes = new byte[1024 * 1024];
			int count = raf.read(bytes);
			for(int i=0; -1!=count && i<200; i++) {
				rafw.write(bytes, 0, count);
				count = raf.read(bytes);
			}
			raf.close();
			rafw.close();
			return null;
		}
		
	}
}
