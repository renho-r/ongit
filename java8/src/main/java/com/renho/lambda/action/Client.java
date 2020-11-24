package com.renho.lambda.action;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

interface Action{
	void run(String param);
}

interface StringAction{
	String run(String param);
}

public class Client {
	public static void main(String[] args) {
		execute(param -> System.out.println(param));
		execute(System.out::println);
		System.out.println(executeString(param -> param + "renho"));
		System.out.println(renhoFunction(i -> (i + "")));
		
		User user = new User(1, "renho", 100);
		System.out.println(user.age);
		user.addAge(u -> {u.age += 1;});
		System.out.println(user.age);
		user.addAge(u -> {u.age += 10;});
		System.out.println(user.age);
		
		System.out.println(user.formatName(name -> "name:" + name));
		System.out.println(user.isMan(u -> u.sex));
		
		System.out.println(user.getRandom(() -> Math.random()));
	}
	public static void execute(Action action){
		action.run("Hello!");
	}
	
	public static String executeString(StringAction action){
		return action.run("Hello!");
	}
	
	public static String renhoFunction(Function<Integer, String> func) {
		return func.apply(100);
	}
}

class User {
	
	Integer id;
	String name;
	Integer age;
	boolean sex;
	
	public User() {}
	
	public User(Integer id, String name, Integer age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	public void addAge(Consumer<User> consumer) {
		consumer.accept(this);
	}
	
	public String formatName(Function<String, String> formatFunc) {
		return formatFunc.apply(this.name);
	}
	
	public boolean isMan(Predicate<User> p) {
		return p.test(this);
	}
	
	public Double getRandom(Supplier<Double> s) {
		return s.get();
	}
}
