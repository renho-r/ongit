package com.renho.io;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FileTest {
	
	String filePath = "h://javaIoTest/createNewFile/";
	String fileName = "createNewFile.txt";
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void createNewFile() throws IOException {
		
		File dirFile = new File(filePath);
		assertEquals("文件夹已经存在!", false, dirFile.exists());
		dirFile.mkdirs();
		
		File file = new File(dirFile, fileName);
//		File file = new File(filePath + fileName);
		assertEquals("文件已经存在!", false, file.exists());
		file.createNewFile();
	}

	@Test
	public void fileMethod() {
		File file = new File(filePath, fileName);
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getName());
		System.out.println(file.getParent());
		System.out.println(file.getParentFile());//return java.io.File
		System.out.println(file.getPath());
		System.out.println(file.isFile());
		System.out.println(file.isDirectory());
		System.out.println(file.lastModified());
		System.out.println(new Date(file.lastModified()));
		System.out.println(file.length());
		file.renameTo(new File(filePath, "new_" + fileName));
		
		File dirFile = new File(filePath);
		File[] files = dirFile.listFiles();
		for(File f:files) {
			System.out.println(f);
		}
	}
	
}
