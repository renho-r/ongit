package com.renho;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Ganer<Cat> g = new Ganer<Cat>();
		g.add(new BigCat("renho"));
		Cat c = g.get();
		System.out.println(c.getName());
	}
}
