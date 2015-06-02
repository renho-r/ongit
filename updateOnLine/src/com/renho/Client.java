package com.renho;

import java.util.Timer;


public class Client {

	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.schedule(new MyTimeTask(), 1000, 5000);
	}
}
