package com.renho.dubbotest.service.impl;

import com.renho.dubbotest.service.ISayHelloService;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

public class SayHelloServiceImpl implements ISayHelloService {

	public String sayHello(String name) {

		InetAddress addr = null;
		String ip = null;
		String address = null;
		System.out.println(System.currentTimeMillis());
		try {
			TimeUnit.SECONDS.sleep(3);
			addr = InetAddress.getLocalHost();
			ip = addr.getHostAddress().toString();//获得本机IP　　
			address = addr.getHostName().toString();//获得本机名称

			System.out.println(ip + ":" + address);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return ip + ":" + address + ":" + System.currentTimeMillis();
	}

}
