package com.renho.dns;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.hdfs.DistributedFileSystem;
import org.apache.hadoop.hdfs.DistributedFileSystem.DiskStatus;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HadoopTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@SuppressWarnings("deprecation")
	@Test
	public void dnsTest() throws IOException {
		Configuration cf = new Configuration();
		FileSystem fs = FileSystem.get(cf);
		if (fs instanceof DistributedFileSystem) {
			DistributedFileSystem dfs = (DistributedFileSystem) fs;
			DiskStatus ds = dfs.getDiskStatus();
			long capacity = ds.getCapacity()/(1024*1024);
			long used = ds.getDfsUsed()/(1024*1024);
			long remaining = ds.getRemaining()/(1024*1024);
			long nonDfsUsed = capacity - remaining - used;
			Date now = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
			String dateNow = sdf.format(now);
			System.out.println(capacity);
			System.out.println(used);
			System.out.println(remaining);
			System.out.println(nonDfsUsed);
			System.out.println(dateNow);
		}
	}

}
