package com.renho.dataStructure.stack;

public class Stack {

	private int size;
	private long[] stackArray;
	private int top;
	
	public Stack(int size) {
		this.size = size;
		this.stackArray = new long[this.size];
		this.top = -1;
	}
	
	public void push(long value) {
		this.stackArray[++top] = value;
	}
	
	public long pop() {
		return this.stackArray[top--];
	}
	
	public long peek() {
		return this.stackArray[top];
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public boolean isFull() {
		return top == this.size - 1;
	}
}
