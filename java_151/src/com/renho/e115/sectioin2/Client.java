package com.renho.e115.sectioin2;

public class Client {
	public static void main(String[] args) {
		Invoker.m1();
		Invoker.m2();
	}

}

class Foo {
	public static boolean m() {
		// ȡ�õ�ǰջ��Ϣ
		StackTraceElement[] sts = new Throwable().getStackTrace();
		// ����Ƿ���m1��������
		for (StackTraceElement st : sts) {
			if (st.getMethodName().equals("m1")) {
				return true;
			}
		}
		throw new RuntimeException("��m1�����⣬�÷���������������������");
	}
}

class Invoker {
	// �÷�����ӡ��true
	public static void m1() {
		System.out.println(Foo.m());
	}

	// �÷�����ӡ��false
	public static void m2() {
		System.out.println(Foo.m());
	}
}
