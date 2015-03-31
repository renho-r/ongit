package com.renho.structural.composite;

public class Leaf extends Component {

	public Leaf(String name) {
		super(name);
	}

	@Override
	public void add(Component component) {
		System.out.println("cannot add to a leaf");
	}

	@Override
	public void remove(Component component) {
		System.out.println("cannot remove from a leaf");
	}

	@Override
	public void display(int depth) {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<depth; i++) {
			sb.append("-");
		}
		System.out.println(sb + name);
	}

}
