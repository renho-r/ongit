package com.renho.internet.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {

	public static void main(String[] args) throws IOException {
		byte[] buf = "renho".getBytes();
		DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getLocalHost(), 8080);
		DatagramSocket ds = new DatagramSocket();
		ds.send(dp);
		ds.close();
	}

}
