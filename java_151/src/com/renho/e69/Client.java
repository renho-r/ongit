package com.renho.e69;

import java.util.ArrayList;
import java.util.List;

public class Client {
	public static void main(String[] args) {
		// ����һ�����������ַ������б�
		List<String> c = new ArrayList<String>();
		c.add("A");
		c.add("B");
		// ����һ������c���ַ����б�
		List<String> c1 = new ArrayList<String>(c);
		// ͨ��subList������c��ͬ���б�
		List<String> c2 = c.subList(0, c.size());
		// c2����һ��Ԫ��
		c2.add("C");
		System.out.println("c == c1? " + c.equals(c1));
		System.out.println("c == c2? " + c.equals(c2));

	}
}
