package com.renho.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class InputStreamTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	String filePath = "h://javaIoTest/createNewFile/";
	String fileName = "createNewFile.txt";
	
//	@Test
	public void readLenTest() {
		File file = new File(filePath, fileName);
		InputStream in = null;
		byte[] bytes = new byte[1024];
		byte[] titles = "文件内容".getBytes();
//		for(int i=0; i<titles.length; i++) {
//			bytes[i] = titles[i];
//		}
		System.arraycopy(titles, 0, bytes, 0, titles.length);
		try {
			in = new FileInputStream(file);
			int count = in.read(bytes, 8, bytes.length - 8);
			while(-1 != count) {
				System.out.println(new String(bytes, 0, count+8));
				count = in.read(bytes, 8, bytes.length - 8);
				System.out.println("-----------------------------");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
//	@Test
	public void readTest() {
		File file = new File(filePath, fileName);
		InputStream in = null;
		byte[] bytes = new byte[1024];
		try {
			in = new FileInputStream(file);
			int count = in.read(bytes);
			while(-1 != count) {
//				System.out.println(new String(bytes));error
				System.out.println(new String(bytes, 0, count));
				count = in.read(bytes);
				System.out.println("-----------------------------");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	//skip \n算2个
	@Test
	public void readSkipTest() {
		File file = new File(filePath, fileName);
		InputStream in = null;
		byte[] bytes = new byte[1024];
		try {
			in = new FileInputStream(file);
			Long[] skips = new Long[50];
			int lIndex = 0;
			long skipLength = in.skip(8);
			skips[lIndex] = skipLength;
			int count = in.read(bytes);
			while(-1 != count) {
//				System.out.println(new String(bytes));error
				System.out.println(new String(bytes, 0, count));
				skipLength = in.skip(8);
				lIndex++;
				skips[lIndex] = skipLength;
				count = in.read(bytes);
				System.out.println("-----------------------------");
			}
			System.out.println(Arrays.deepToString(skips));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
