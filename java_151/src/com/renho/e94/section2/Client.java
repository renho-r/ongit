package com.renho.e94.section2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Client {
	public static void main(String[] args) {

	}
}

class Foo<T> {
	// ���ٳ�ʼ�����ɹ��캯����ʼ��
	private T t;
	private T[] tArray;
	private List<T> list = new ArrayList<T>();

	// ���캯����ʼ��
	public Foo() {
		try {
			Class<?> tType = Class.forName("");
			t = (T) tType.newInstance();
			tArray = (T[]) Array.newInstance(tType, 5);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
