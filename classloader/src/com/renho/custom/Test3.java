package com.renho.custom;

public class Test3 implements SuperTest{
	static {
		System.out.println("Test3的静态初始化块执行了！");
	}

	@Override
	public void renho() {
		System.out.println("renho");
	}
}