package com.renho.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

public class FlyWeightFactory {

	private Map<String, FlyWeight> map = new HashMap<String, FlyWeight>();
	
	public FlyWeightFactory() {
		map.put("X", new ConcreteFlyWeight());
		map.put("Y", new ConcreteFlyWeight());
		map.put("Z", new ConcreteFlyWeight());
	}
	
	public FlyWeight getFlyWeight(String key) {
		return (FlyWeight)map.get(key);
	}
}
