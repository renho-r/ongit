package com.renho.guava.basicutilities;

import com.google.common.base.Optional;

public class OptionalTest {

	public static void main(String[] args) {
		Optional<Integer> possible = Optional.of(5);
		System.out.println(possible.isPresent());
		System.out.println(possible.get());
		
//		possible = Optional.absent();
		possible = Optional.fromNullable(null);
		System.out.println(possible.isPresent());
//		System.out.println(possible.get());
	}
}
