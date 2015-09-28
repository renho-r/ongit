package com.renho.server;

import java.io.IOException;
import java.io.InputStream;

public class RequestHandler {

	public static void handle(InputStream in) {
		byte[] reqDatas = new byte[2048];
		try {
			int length = in.read(reqDatas);
			String reqData = new String(reqDatas, 0, length);
			System.out.println(reqData);
			String[] req = reqData.split("\\r\\n");
			System.out.println("method:" + req[0].split(" ")[0]);
			System.out.println("url:" + req[0].split(" ")[1]);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
