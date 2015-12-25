package com.renho.behavior.visitor.manandwoman;

import java.util.ArrayList;
import java.util.List;

public class ObjectStructure {

	private List<Visitor> list = new ArrayList<>();
	
	public void add(Visitor v) {
		list.add(v);
	}
	
	public void remove(Visitor v) {
		list.remove(v);
	}
	
	public void display(Person person) {
		for(Visitor visitor:list) {
			person.accept(visitor);
		}
	}
}
