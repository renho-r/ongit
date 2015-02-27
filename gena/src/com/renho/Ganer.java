package com.renho;

public class Ganer<T extends Cat> {

	private T t;
	public void add(T t) {
		this.t = t;
	}
	public T get() {
		return t;
	}
}
