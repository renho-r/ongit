package com.renho;

import java.io.File;

public class TestData {

	public static String[] getIps() {
		File file = new File("E:\\dns_recursion_domain_top\\20150806\\0000");
		File[] fs = file.listFiles();
		String[] ips = new String[fs.length];
		int i = 0;
		for(File f:fs) {
			ips[i++] = f.getName().split("_")[0];
		}
		return ips;
	}
	
}
