package com.renho.stream;

import java.util.ArrayList;
import java.util.List;

public class Client {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("renho0");
		list.add("renho1");
		list.add("renho2");
		list.add("renho3");

//		System.out.println(list.stream().count());
//		list.stream().forEach(System.out::println);
//		list.forEach(System.out::println);
//		list.forEach(e -> System.out.println(e));
//		list.stream().forEach(e -> System.out.println(e));
		list.stream().filter(e -> "renho0".equals(e))
				.forEach(e -> System.out.println(e));

	}

}
