package com.renho.e29;

public class Client {
	public static void main(String[] args) {
		Client cilent = new Client();
		int i=140;
		//�ֱ𴫵�int���ͺ�Integer����
		cilent.f(i);
		cilent.f(Integer.valueOf(i));
	}
	
	public void f(long a) {
		System.out.println("�������͵ķ���������");
	}

	public void f(Long a) {
		System.out.println("��װ���͵ķ���������");
	}
}

