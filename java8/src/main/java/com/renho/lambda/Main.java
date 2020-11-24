package com.renho.lambda;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Arrays.asList("a", "b", "c").forEach(e -> System.out.println(e));

		Arrays.asList("a", "b", "c").forEach(
				(String e) -> System.out.println(e));

		Arrays.asList("a", "b", "d").forEach(e -> {
			System.out.print(e);
			System.out.print(e);
		});

		String separator = ",";
		Arrays.asList("a", "b", "d").forEach(
				(String e) -> System.out.print(e + separator));

		Arrays.asList("a", "b", "d").sort((e1, e2) -> {
			int result = e1.compareTo(e2);
			return result;
		});
		System.out.println();
		FunctionalDefaultMethods fdm = new FunctionalDefaultMethods() {

			@Override
			public void method() {
				System.out.println(11111);
			}
		};
		fdm.defaultMethod();
	}

}
