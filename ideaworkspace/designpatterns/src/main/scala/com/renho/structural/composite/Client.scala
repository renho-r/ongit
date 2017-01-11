package com.renho.structural.composite

/**
  * Created by renho on 2016/7/11.
  */
object Client {
	def main(args: Array[String]) {
		var root = new Composite("root");
		root.add(new Leaf("LEAF A"));
		root.add(new Leaf("LEAF B"));

		var comp = new Composite("Composite X");
		comp.add(new Leaf("LEAF XA"));
		comp.add(new Leaf("LEAF XB"));

		root.add(comp);

		var comp0 = new Composite("Composite XY");
		comp0.add(new Leaf("LEAF XYA"));
		comp0.add(new Leaf("LEAF XYB"));

		comp.add(comp0);

		root.add(new Leaf("LEAF C"));
		var leafd = new Leaf("LEAF D");
		root.add(leafd);

		root.display(0);

		root.remove(leafd);

		root.display(0);
	}
}
