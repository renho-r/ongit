package com.renho.e37.section2;

/**
 *
 * @author Phenix
 * 2011-3-17
 */
public class Client {
	public static void main(String[] args) {
		new Sub();
	}
}

class Base{
	{
		System.out.println("1�����๹������");
	}
	public Base(){
		System.out.println("2�����๹�캯��");
	}
}

class Sub extends Base{
	{
		System.out.println("3�����๹������");
	}
	public Sub(){
		super();
		System.out.println("4�����๹�캯��");
	}	
}
