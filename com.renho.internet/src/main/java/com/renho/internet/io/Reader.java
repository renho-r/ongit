package com.renho.internet.io;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.StringReader;

public class Reader {

	public static void main(String[] args) throws IOException {
		String fileName = "data/nio-data.txt";
		//BufferedReader
		/*BufferedReader br = new BufferedReader(new FileReader(fileName));
		String line = null;
		while((line=br.readLine()) != null) {
			System.out.println(line);
		}
		br.close();*/
		
		//LineNumberReader
		/*LineNumberReader lnr = new LineNumberReader(new FileReader(fileName));
		lnr.mark(1024);
		System.out.println(lnr.getLineNumber());
		System.out.println(lnr.readLine());
		System.out.println(lnr.getLineNumber());
		lnr.reset();
		lnr.skip(Long.MAX_VALUE);
		System.out.println(lnr.getLineNumber() + 1);
		lnr.close();*/
		
		//StringReader
		StringReader sr = new StringReader("renho");
		int ch = -1;
		while(-1 != (ch = sr.read())) {
			System.out.print((char)ch);
		}
		sr.close();
	}

}
