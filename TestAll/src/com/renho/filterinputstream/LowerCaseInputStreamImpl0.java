package com.renho.filterinputstream;

import java.io.IOException;
import java.io.InputStream;

public class LowerCaseInputStreamImpl0 extends LowerCaseInputStream0 {

	public LowerCaseInputStreamImpl0(InputStream is) {
		super(is);
	}

	@Override
	public int read() throws IOException {
		System.out.println("LowerCaseInputStreamImpl0 -- >read------>start");
		int c = addedBehavier();
		System.out.println("LowerCaseInputStreamImpl0 -- >read------>end");
		return c;
	}
	
	public int addedBehavier() throws IOException {
		System.out.println("LowerCaseInputStreamImpl0 -- >addedBehavier------>start");
		int c = super.read();
		System.out.println("LowerCaseInputStreamImpl0 -- >addedBehavier------>end");
		return 'd' == (char)c? 'r': c;
	}
}
