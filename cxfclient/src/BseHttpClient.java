package com.asiainfo.nfissuedtask.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.net.URL;
import java.net.URLConnection;

public class BseHttpClient {

	public static void main(String[] args) throws Exception {
		InputStream is = getSoapInputStream();
		int count = is.available();
		byte[] bs = new byte[count];
		is.read(bs);
		String result = new String(bs, "UTF-8");
		System.out.println(result);
	}
	
	private static InputStream getSoapInputStream() throws Exception {
		try {
			String soap = getXml();
			if (soap == null) {
				return null;
			}
			URL url = new URL("http://10.1.69.55:9090/NetXpert/wsservices/syncOrder");
			URLConnection conn = url.openConnection();
			conn.setUseCaches(false);
			conn.setDoInput(true);
			conn.setDoOutput(true);

			conn.setRequestProperty("Content-Length", Integer.toString(soap.length()));
			conn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
			conn.setRequestProperty("SOAPAction", "http://api.ddos.asiainfo.com/syncOrder");
			
			OutputStream os = conn.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os, "utf-8");
			osw.write(soap);
			osw.flush();
			osw.close();

			InputStream is = conn.getInputStream();
			return is;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String getXml() throws IOException {
		RandomAccessFile raf = new RandomAccessFile("order.xml", "r");
//		RandomAccessFile raf = new RandomAccessFile("order_bak.xml", "r");
		byte[] bs = new byte[(int) raf.length()];
		raf.read(bs);
		raf.close();
		return new String(bs, "UTF-8");
	}
	
}
