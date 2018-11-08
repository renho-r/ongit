package com.renho.server;

import java.io.IOException;
import java.io.InputStream;

public class RequestHandler {

	public static void handle(InputStream in) {
		byte[] reqDatas = new byte[20480];
		while(true) {
			try {
				reqDatas = new byte[20480];
				int length = in.read(reqDatas);
				String reqData = new String(reqDatas, 0, length);
				System.out.println(reqData);
				String[] req = reqData.split("\\r\\n");
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
