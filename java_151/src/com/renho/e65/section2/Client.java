package com.renho.e65.section2;

import java.util.Arrays;
import java.util.List;

public class Client {

	public static void main(String[] args) {
		int[] data = { 1, 2, 3, 4, 5 };
		List list = Arrays.asList(data);
		System.out.println("Ԫ�����ͣ�" + list.get(0).getClass());
		System.out.println("ǰ���Ƿ���ȣ�" + data.equals(list.get(0)));
	}

}
