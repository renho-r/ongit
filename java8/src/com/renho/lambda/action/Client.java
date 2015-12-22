package com.renho.lambda.action;

interface Action{
	void run(String param);
}

public class Client {
	public static void main(String[] args) {
		execute(param -> System.out.println(param));
		execute(System.out::println);
	}
	public static void execute(Action action){
		action.run("Hello!");
	}
}
