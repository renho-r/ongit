package com.renho.e113.section3;

public class Client {

	public static void doSomething() {
		try {
			// �����׳��쳣
			throw new RuntimeException();
		} finally {
			return;
		}
	}

	public static void main(String[] args) {
		try {
			doSomething();
		} catch (RuntimeException e) {
			System.out.println("������Զ�����ᵽ�");
		}
	}

}
