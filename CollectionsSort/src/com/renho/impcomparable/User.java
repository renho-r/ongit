package com.renho.impcomparable;

public class User implements Comparable<User> {

	private Integer id;
	private String name;
	@Override
	public int compareTo(User o) {
		//return this.getId().compareTo(o.getId());
		if(this.getId() >= o.getId()) {
			return 1;
		}else {
			return 0;
		}
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
