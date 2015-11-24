package com.renho.internet.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class URLTest {

	public static void main(String[] args) throws IOException {
		URL url = new URL("http://localhost:9090/testJs/view/testJs.html");
		URLConnection urlConnection = url.openConnection();
	 	InputStream in = urlConnection.getInputStream();
	 	byte[] bs = new byte[1024];
	 	int count = in.read(bs);
	 	while(-1 != count) {
	 		System.out.println(new String(bs, 0, count));
	 		count = in.read(bs);
	 	}
	}

}
