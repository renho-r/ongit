package com.renho.structural.proxy;

public class Client {

	public static void main(String[] args) {
//		Subject proxy = new Proxy();
		Proxy proxy = new Proxy();
		proxy.request();
	}
}
