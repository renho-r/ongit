package com.renho.stream;

import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class ForceToCollector<T, A, R> implements Collector<T, A, R> {

	private Supplier<A> supplier;
	private BiConsumer<A, T> accumulator;
	private BinaryOperator<A> combiner;
	private Set<Characteristics> characteristics;
	
	public ForceToCollector(Supplier<A> supplier, BiConsumer<A, T> accumulator, BinaryOperator<A> combiner,
			Set<java.util.stream.Collector.Characteristics> characteristics) {
		super();
		this.supplier = supplier;
		this.accumulator = accumulator;
		this.combiner = combiner;
		this.characteristics = characteristics;
	}

	@Override
	public Supplier<A> supplier() {
		return supplier;
	}

	@Override
	public BiConsumer<A, T> accumulator() {
		return accumulator;
	}

	@Override
	public BinaryOperator<A> combiner() {
		return combiner;
	}

	@Override
	public Function<A, R> finisher() {
		return null;
	}

	@Override
	public Set<java.util.stream.Collector.Characteristics> characteristics() {
		return characteristics;
	}
}
