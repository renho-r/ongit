package com;

import java.lang.reflect.Field;

public class A extends B {
	public void set(int x) throws Exception {
		Field i = ((Class<? extends A>) this.getClass().getGenericSuperclass()).getDeclaredField("i");
		i.setAccessible(true);
		i.set(this, x);
	}

	public Object get() throws Exception {
		Field i = ((Class<? extends A>) this.getClass().getGenericSuperclass()).getDeclaredField("i");
		i.setAccessible(true);
		return i.get(this);
	}

	public static void main(String[] args) throws Exception {

		A a = new A();
		System.out.println(a.get());

		a.set(777);
		System.out.println(a.get());

	}

}