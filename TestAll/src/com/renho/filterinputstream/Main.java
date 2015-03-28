package com.renho.filterinputstream;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {

	public static void main(String[] args) throws IOException {
//		LowerCaseInputStream lcis = new LowerCaseInputStream(
//				new BufferedInputStream(new FileInputStream(new File(
//						"c:\\unintall.log"))));
//		int c;
//		while((c = lcis.read()) >= 0) {
//			System.out.print((char)c);
//		}
//		lcis.close();
		InputStream fis = new BufferedInputStream(new FileInputStream(new File("c:\\a.txt")));
		LowerCaseInputStream0 lcis0 = new LowerCaseInputStreamImpl(fis);
		LowerCaseInputStream0 lcis1 = new LowerCaseInputStreamImpl0(lcis0);
		int c;
		while((c = lcis1.read()) >= 0) {
			System.out.print((char)c);
			System.out.println("--------------------------------------");
		}
		lcis1.close();
	}

}
