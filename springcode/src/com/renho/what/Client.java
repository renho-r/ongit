package com.renho.what;

interface I {

	String getA(String s);

}

class A {

	public String getA(String s) {
		return "xxx" + s;
	}

}

class Ia extends A implements I {

}

public class Client {

	public static void main(String[] args) {
		I i = new Ia();
		System.out.println(i.getA("s"));
	}

}
