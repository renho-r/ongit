package com.renho.e84.section1;

public class Client {
	public static void main(String[] args) {
		System.out.println(Season.Spring.getDesc());
	}
}

enum Season {
	Spring("��"), Summer("��"), Autumn("��"), Winter("��");

	private String desc;

	Season(String _desc) {
		desc = _desc;
	}

	// ���ö��ֵ
	public String getDesc() {
		return desc;
	}
}
