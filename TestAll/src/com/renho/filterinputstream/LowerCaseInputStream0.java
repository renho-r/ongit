package com.renho.filterinputstream;

import java.io.IOException;
import java.io.InputStream;

public class LowerCaseInputStream0 extends InputStream {

	//decorator装饰模式
	
	private InputStream is;
	
	public LowerCaseInputStream0(InputStream is) {
		super();
		this.is = is;
	}
	
	@Override
	public int read() throws IOException {
		System.out.println("LowerCaseInputStream0 -- >read------>start:is:" + is);
		int c = is.read();
		System.out.println("LowerCaseInputStream0 -- >read------>end:is:" + is);
		return c;
	}
}
