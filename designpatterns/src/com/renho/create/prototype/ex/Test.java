package com.renho.create.prototype.ex;

public class Test {

	@org.junit.Test
	public void test() {
		Sample sample = new Sample1();
		System.out.println(sample.getName());
		Sample temp = (Sample) sample.clone();
		System.out.println(temp.getName());
		System.out.println(sample.equals(temp));
	}

}
