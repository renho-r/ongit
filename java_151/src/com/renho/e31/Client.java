package com.renho.e31;

public class Client {
	public static void main(String[] args) {
		//���ýӿڵ�ʵ��
		B.s.doSomething();
	}
}
//�ڽӿ��д���ʵ�ִ���
interface B{	
	public static final S s = new S(){
		public void doSomething(){
			System.out.println("���ڽӿ���ʵ����");
		}
	};
	
}
//��ʵ�ֵĽӿ�
interface S{
	public void doSomething();
}
