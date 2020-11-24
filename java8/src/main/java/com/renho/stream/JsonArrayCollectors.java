package com.renho.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collector;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JsonArrayCollectors {
	
	public static <T> Collector<T, ?, JSONArray> toJsonArrayx() {
		return new ForceToCollector<>((Supplier<JSONArray>) JSONArray::new, JSONArray::add, null,
				Collections.unmodifiableSet(EnumSet.of(Collector.Characteristics.IDENTITY_FINISH)));
    }
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		User user1 = new User();
		user1.setUserId(1);
		user1.setUserName("renho1");
		
		User user2 = new User();
		user2.setUserId(2);
		user2.setUserName("renho2");
		
		List<User> users = new ArrayList<>();
		users.add(user1);
		users.add(user2);
		
		JSONArray jsonArray = users.stream().map(user -> {
			return JSONObject.fromObject(user);
		}).collect(JsonArrayCollectors.toJsonArrayx());
		
		jsonArray.forEach(System.out::println);
	}
	
}