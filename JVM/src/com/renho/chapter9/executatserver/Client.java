package com.renho.chapter9.executatserver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Client {

	public static void main(String[] args) throws IOException {
		InputStream in = new FileInputStream(new File("c://Test.class"));
		byte[] b = new byte[in.available()];
		in.read(b);
		in.close();
		
		JavaClassExecuter.execute(b);
	}

}
