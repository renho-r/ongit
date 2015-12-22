package com.renho.testlong;

public class P1 {

	private volatile long b = 0;

	public void set1() {
		b = 0;
	}

	public void set2() {
		b = -1;
	}

	public void check() {
		if (0 != b && -1 != b) {
			System.out.println(b);
			System.err.println("Error");
		}
	}
}