package com.renho.chapter1.e1;

public class Client {

	public static void main(String[] args) {
		for(int i=0; i<10; i++) {
			Thread t = new Thread(new Calculator(i));
			t.start();
		}
	}

}
