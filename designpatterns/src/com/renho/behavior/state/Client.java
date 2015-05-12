package com.renho.behavior.state;

public class Client {

	public static void main(String[] args) {
		State state = new ConcreteStateA(6);
		Context context = new Context(state);
		context.request();
		context.request();
		context.request();
		context.request();
		context.request();
		context.request();
	}

}
