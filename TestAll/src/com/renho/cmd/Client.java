package com.renho.cmd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Client {

	public static void main(String[] args) throws IOException {
		Runtime runtime = Runtime.getRuntime();
		Process process = runtime.exec("ping www.baidu.com -t");
		InputStream in = process.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in, "GBK"));
		String s = null;
		while ((s = br.readLine()) != null) {
			System.out.println(s);
		}
	}

}
