package com.renho.filterinputstream;

import java.io.IOException;
import java.io.InputStream;

public class LowerCaseInputStreamImpl extends LowerCaseInputStream0 {

	public LowerCaseInputStreamImpl(InputStream is) {
		super(is);
	}

	@Override
	public int read() throws IOException {
		System.out.println("LowerCaseInputStreamImpl -- >read------>start");
		int c = addedBehavier();
		System.out.println("LowerCaseInputStreamImpl -- >read------>end");
		return c;
	}
	
	public int addedBehavier() throws IOException {
		System.out.println("LowerCaseInputStreamImpl -- >addedBehavier------>start");
		int c = super.read();
		System.out.println("LowerCaseInputStreamImpl -- >addedBehavier------>end");
		return -1==c ? c : Character.toLowerCase((char)c);
	}
}
