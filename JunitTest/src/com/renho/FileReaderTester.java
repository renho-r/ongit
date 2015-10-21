package com.renho;

import static org.junit.Assert.*;

import java.io.FileReader;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FileReaderTester {
	
	private FileReader in = null;
	
	@Before
	public void setUp() throws Exception {
		in = new FileReader("data.txt");
	}

	@After
	public void tearDown() throws Exception {
		in.close();
	}

	@Test
	public void testRead() throws IOException {
		char ch = '&';
		for(int i=0; i<4; i++) {
			ch = (char) in.read();
		}
		assertEquals('c', ch);
	}
	
	@Test(expected=IOException.class)
	public void testReadAfterClose() throws IOException {
		in.close();
		in.read();
	}
}
