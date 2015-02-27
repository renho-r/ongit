package com.renho.dataStructure.stack;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Stack stack = new Stack(10);
		stack.push(100);
		stack.push(99);
		stack.push(88);
		stack.push(77);
		System.out.println(stack.peek());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}
}
