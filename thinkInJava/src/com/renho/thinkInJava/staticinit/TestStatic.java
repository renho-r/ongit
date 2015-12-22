package com.renho.thinkInJava.staticinit;

public class TestStatic {

	static String str0 = "str0";
	static String str1;
	
	static {
		str1 = "str1";
		System.out.println("str1 已经初始化!");
	}
	
	static void showStr() {
		System.out.println("准备使用str0, str1");
		System.out.println(str0);
		System.out.println(str1);
	}
	
	public static void main(String[] args) {
		System.out.println("start");
		TestStatic.showStr();
	}
}
