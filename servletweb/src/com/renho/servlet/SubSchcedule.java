package com.renho.servlet;

import java.util.Map;

public class SubSchcedule extends Schcedule {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Map<String, String> getMapping() {
		Map<String, String> map = super.getMapping();
		map.put("name", "start_junc_id");
		return map;
	}
	
}
