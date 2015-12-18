package com.renho.hadoop.ch03;

// cc ShowFileStatusTest Demonstrates file status information

import java.io.*;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.*;

// vv ShowFileStatusTest
public class ShowFileStatusTest {
	private FileSystem fs;

	@Before
	public void setUp() throws IOException {
		Configuration conf = new Configuration();
		String uri = "hdfs://10.1.37.100:9000/input/mywrite/eclipse_gc.log";
		fs = FileSystem.get(URI.create(uri), conf);
	}

	@After
	public void tearDown() throws IOException {
		
	}
	
	@Test
	public void fileStatusForFile() throws IOException {
		Path path = new Path("hdfs://10.1.37.100:9000/input/mywrite/eclipse_gc.log");
		FileStatus fileStatus = fs.getFileStatus(path);
		System.out.println(fileStatus.getOwner());
		System.out.println(fileStatus.getBlockSize());
	}

	@Test
	public void fileStatusForDirectory() throws IOException {
		
	}

}
