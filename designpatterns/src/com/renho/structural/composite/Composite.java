package com.renho.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class Composite extends Component{

	public Composite(String name) {
		super(name);
	}

	private List<Component> list = new ArrayList<Component>();
	
	@Override
	public void add(Component component) {
		list.add(component);
	}

	@Override
	public void remove(Component component) {
		list.remove(component);
	}

	@Override
	public void display(int depth) {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<depth; i++) {
			sb.append("-");
		}
		System.out.println(sb + name);
		for(Component c:list) {
			c.display(depth + 2);
		}
	}

}
