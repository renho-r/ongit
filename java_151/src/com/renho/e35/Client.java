package com.renho.e35;

public class Client {
	public static void main(String[] args) {
		Son s = new Son();
		s.doSomething();
	}
}

// ����
class Father {
	Father() {
		new Other();
	}
}

// ����
class Son extends Father {
	public void doSomething() {
		System.out.println("Hi,show me something");
	}
}

// �����
class Other {
	public Other() {
		new Son();
	}
}