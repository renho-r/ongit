package com.renho.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OutputStreamTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	String filePath = "h://javaIoTest/createNewFile/";
	String srcFileName = "createNewFile.txt";
	String desFileName = "createNewFile_write.txt";
	@Test
	public void writeTest() throws IOException {
		File srcFile = new File(filePath, srcFileName);
		File desFile = new File(filePath, desFileName);
//		OutputStream out = new FileOutputStream(desFile);
		OutputStream out = new FileOutputStream(desFile, true);
		InputStream in = new FileInputStream(srcFile);
		
		byte[] bytes = new byte[1024];
		int readCount = in.read(bytes);
		while(-1 != readCount) {
//			out.write(bytes);
			out.write(bytes, 0, readCount);
			readCount = in.read(bytes);
		}
		out.flush();
		out.close();
		in.close();
	}

}
