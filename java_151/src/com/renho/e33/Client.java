package com.renho.e33;

public class Client {
	public static void main(String[] args) {
		Base base = new Sub();
		// ���÷Ǿ�̬����
		base.doAnything();
		// ���þ�̬����
		base.doSomething();
	}
}

class Base {
	// ���ྲ̬����
	public static void doSomething() {
		System.out.println("���Ǹ��ྲ̬����");
	}

	// ����Ǿ�̬����
	public void doAnything() {
		System.out.println("���Ǹ���Ǿ�̬����");
	}
}

class Sub extends Base {
	// ����ͬ����ͬ�����ľ�̬����
	public static void doSomething() {
		System.out.println("�������ྲ̬����");
	}

	// ��д����ķǾ�̬����
	@Override
	public void doAnything() {
		System.out.println("��������Ǿ�̬����");
	}
}
