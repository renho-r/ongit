package com.renho.e11;

/**
 * ��������ϰ�ߣ���ʽ����UID
 *
 */

public class Consumer {

	public static void main(String[] args) throws Exception {
		// �����л���
		Person p = (Person) SerializationUtils.readObject();
		System.out.println("name="+p.getName());
	}
}
