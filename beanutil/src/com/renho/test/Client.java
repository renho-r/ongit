package com.renho.test;

import org.apache.commons.collections4.map.SingletonMap;

public class Client {

	public static void main(String[] args) {
		SingletonMap<String, String> singletonMap = new SingletonMap<>("key-renho", "value-renho");
		singletonMap.put("key-renho", "value-renho0");
		singletonMap.put("key-renho0", "value-renho1");
	}

}
