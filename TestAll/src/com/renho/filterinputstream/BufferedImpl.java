package com.renho.filterinputstream;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class BufferedImpl extends BufferedInputStream {

	public BufferedImpl(InputStream in) {
		super(in);
	}

	@Override
	public synchronized int read() throws IOException {
		int c = super.read();
		return -1==c ? c : Character.toLowerCase((char)c);
	}
}
