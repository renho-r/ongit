package com.renho.internet.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPServer {

	public static void main(String[] args) {
		DatagramSocket ds = null;;
		try {
			ds = new DatagramSocket(8080);
			byte[] buf = new byte[65508];
			while(true) {
				DatagramPacket dp = new DatagramPacket(buf, buf.length);
				ds.receive(dp);
				System.out.println(new String(dp.getData()));			
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(null != ds) {
				ds.close();
			}
		}
	}

}
