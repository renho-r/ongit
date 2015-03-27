package com.renho.create.prototype;

public class Client {

	public static void main(String[] args) {
		Prototype prototype0 = new ConcretePrototypeA();
		prototype0.setType("A");
		Person person = new Person("renho", 100);
		
		prototype0.setPerson(person);
		
		Prototype prototype1 = prototype0.clone();
		Prototype prototype2 = prototype0.clone();
		
		System.out.println(prototype0.getType());
		System.out.println(prototype0.getPerson().getName());
		System.out.println(prototype1.getType());
		System.out.println(prototype1.getPerson().getName());
		System.out.println(prototype2.getType());
		System.out.println(prototype2.getPerson().getName());
		
		System.out.println(prototype0);
		System.out.println(prototype0.getPerson());
		System.out.println(prototype1);
		System.out.println(prototype1.getPerson());
		System.out.println(prototype2);
		System.out.println(prototype2.getPerson());
		
		System.out.println("prototype0.equals(prototype1):" + prototype0.equals(prototype1));
		System.out.println("prototype0.getPerson().equals(prototype1.getPerson())" + prototype0.getPerson().equals(prototype1.getPerson()));
		System.out.println("prototype0 == prototype1:" + (prototype0 == prototype1));
		System.out.println("prototype0.getPerson() == prototype1.getPerson():" + (prototype0.getPerson() == prototype1.getPerson()));
		
		Prototype prototype3 = new ConcretePrototypeB();
		prototype3.setType("B");
		Person person0 = new Person("renho", 100);
		
		prototype3.setPerson(person0);
		
		Prototype prototype4 = prototype3.clone();
		Prototype prototype5 = prototype3.clone();
		
		System.out.println(prototype3.getType());
		System.out.println(prototype3.getPerson().getName());
		System.out.println(prototype4.getType());
		System.out.println(prototype4.getPerson().getName());
		System.out.println(prototype5.getType());
		System.out.println(prototype5.getPerson().getName());
		
		System.out.println(prototype3);
		System.out.println(prototype3.getPerson());
		System.out.println(prototype4);
		System.out.println(prototype4.getPerson());
		System.out.println(prototype5);
		System.out.println(prototype5.getPerson());
		
		System.out.println("prototype3.equals(prototype4):" + prototype3.equals(prototype4));
		System.out.println("prototype3.getPerson().equals(prototype4.getPerson())" + prototype3.getPerson().equals(prototype4.getPerson()));
		System.out.println("prototype3 == prototype4:" + (prototype3 == prototype4));
		System.out.println("prototype3.getPerson() == prototype4.getPerson():" + (prototype3.getPerson() == prototype4.getPerson()));
	}

}
