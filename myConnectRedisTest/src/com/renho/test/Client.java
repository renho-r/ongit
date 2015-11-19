package com.renho.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

public class Client {

	public static void main(String[] args) {
		Socket socket = new Socket();
		try {
			socket.setReuseAddress(true);
			socket.setKeepAlive(true);
			socket.setTcpNoDelay(true);
			socket.setSoLinger(true, 0);
			socket.connect(new InetSocketAddress("127.0.0.1", 6379), 30 * 1000);
			socket.setSoTimeout( 60 * 1000);
			OutputStream os = socket.getOutputStream();
			InputStream inputStream = socket.getInputStream();
			
//			os.write(42);
		    //os.writeIntCrLf(1);
//			os.write(49);
//			os.write('\r');
//			os.write('\n');
//		    os.write(36);
////		    os.writeIntCrLf(7);
//		    os.write(55);
//			os.write('\r');
//			os.write('\n');
//		    os.write("FLUSHDB".getBytes());
//		    os.write('\r');
//			os.write('\n');
			os.write("*1\r\n$7\r\nFLUSHDB\r\n".getBytes());//?
//			
			byte[] recMsg = new byte[1024];
			int count = inputStream.read(recMsg);
			while(count > 0) {
				System.out.print(new String(recMsg, 0, count));
				count = inputStream.read(recMsg);
			}
			
			socket.close();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
