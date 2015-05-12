package com.renho.test;
public class Test3 implements SuperTest{
	static {
		System.out.println("Test3的静态初始化块执行了！");
	}
	public void renho() {
		System.out.println("Test3 renho CCCCCCCCCCCCC");
	}
}