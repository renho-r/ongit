package com.renho.structural.composite;

public class Client {

	public static void main(String[] args) {
		Composite root = new Composite("root");
		root.add(new Leaf("LEAF A"));
		root.add(new Leaf("LEAF B"));
		
		Composite comp = new Composite("Composite X");
		comp.add(new Leaf("LEAF XA"));
		comp.add(new Leaf("LEAF XB"));
		
		root.add(comp);
		
		Composite comp0 = new Composite("Composite XY");
		comp0.add(new Leaf("LEAF XYA"));
		comp0.add(new Leaf("LEAF XYB"));
		
		comp.add(comp0);
		
		root.add(new Leaf("LEAF C"));
		Leaf leafd = new Leaf("LEAF D");
		root.add(leafd);
		
		root.display(0);
		
		root.remove(leafd);
		
		root.display(0);
	}

}
