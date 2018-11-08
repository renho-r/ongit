package com.renho.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Test {

	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(9099);
		while(true) {
			Socket socket = ss.accept();
			InputStream in = socket.getInputStream();
			RequestHandler.handle(in);
			
			OutputStream out = socket.getOutputStream();
			
			/*响应头 start*/
			out.write("HTTP/1.1 200 OK \r\n".getBytes());
			out.write("Content-Type: text/html;charset=utf-8\r\n".getBytes());
			out.write("\r\n".getBytes());
			/*响应头end*/
			
			/*响应正文 start*/
			File file = new File("F:\\workspace\\ongit\\renhoServer\\WebRoot\\", "index.html");
			if (file.exists()) {
				FileInputStream fis = new FileInputStream(file);
				byte[] bytes = new byte[1024];
				int ch = fis.read(bytes, 0, 1024);
				while (ch != -1) {
					out.write(bytes, 0, ch);
					ch = fis.read(bytes, 0, 1024);
				}
				fis.close();
			}
			/*响应正文 end*/
			out.close();
			socket.close();
		}
	}
}
