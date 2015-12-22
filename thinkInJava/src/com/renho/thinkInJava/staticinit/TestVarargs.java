package com.renho.thinkInJava.staticinit;

public class TestVarargs {

	public void exe(Integer ... in) {
		System.out.println("int");
	}
	
	public void exe(Long ... lo) {
		System.out.println("long");
	}
	
	
	public static void main(String[] args) {
		TestVarargs tv = new TestVarargs();
		tv.exe(1);
		tv.exe(new Integer[]{1, 2, 3});
		tv.exe(1, 2, 3);
		tv.exe(1L);
	}

}
