package com.renho.behavior.templatemethod;

public abstract class AbstractClass {

	public void templateMethod() {
		primitiveOperation1();
		primitiveOperation2();
		System.out.println("renho OK!");
	}
	public abstract void primitiveOperation1();
	public abstract void primitiveOperation2();
}
