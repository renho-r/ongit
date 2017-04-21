package com.renho.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Client {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("renho1");
		list.add("renho2");
		list.add("renho3");
		list.add("renho4");

//		System.out.println(list.stream().count());
//		list.stream().forEach(System.out::println);
//		list.forEach(System.out::println);
//		list.forEach(e -> System.out.println(e));
//		list.stream().forEach(e -> System.out.println(e));
//		list.stream().filter(e -> "renho0".equals(e))
//				.forEach(e -> System.out.println(e));
				
		Stream<String> stream = list.stream();
		IntStream iStream = stream.mapToInt(s -> Character.getNumericValue(s.toString().charAt(5)));
		OptionalInt sum = iStream.reduce((identity, op) -> {
			System.out.println("identity:" + identity);
			System.out.println("op:" + op);
			return identity + op;
		});
		System.out.println(sum.getAsInt());
		
	}

}
