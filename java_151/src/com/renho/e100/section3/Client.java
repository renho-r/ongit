package com.renho.e100.section3;

public class Client<T> {

	public static void main(String[] args) {
		// objArray��ʵ�����ͺͱ������Ͷ���String����
		Object[] objArray = { "A", "B" };
		// �׳�ClassCastException
		String[] strArray = (String[]) objArray;

		String[] ss = { "A", "B" };
		// objs����ʵ������String���飬��ʾ����ΪObject����
		Object[] objs = ss;
		// ˳��ת��ΪString����
		String[] strs = (String[]) objs;

	}

}
