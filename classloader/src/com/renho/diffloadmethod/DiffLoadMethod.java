package com.renho.diffloadmethod;

public class DiffLoadMethod {
	public static void main(String[] args) throws ClassNotFoundException {
		ClassLoader loader = DiffLoadMethod.class.getClassLoader();
		System.out.println(loader);
		// ʹ��ClassLoader.loadClass()�������࣬����ִ�г�ʼ����
		//loader.loadClass("com.renho.diffloadmethod.Test2");
		// ʹ��Class.forName()�������࣬Ĭ�ϻ�ִ�г�ʼ����
		//Class.forName("com.renho.diffloadmethod.Test2");
		// ʹ��Class.forName()�������࣬��ָ��ClassLoader����ʼ��ʱͨ���ڶ�����������ִ�о�̬��
		//Class.forName("com.renho.diffloadmethod.Test2", false, loader);
	}
}
