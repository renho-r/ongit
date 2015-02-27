package com.renho;

public class TreeMain {

	public static void main(String[] args) {
		Tree tree = new Tree();
		tree.insert(13, 50);
		tree.insert(8, 50);
		tree.insert(11, 50);
		tree.insert(7, 50);
		tree.insert(16, 50);
		tree.insert(9, 50);
		tree.insert(12, 50);
		tree.insert(6, 50);
		tree.insert(14, 50);
		tree.insert(10, 100);
		tree.insert(17, 200);
		tree.insert(5, 50);
//		System.out.println(tree.find(3));
		tree.delete(8);
//		tree.ldr();
//		tree.dlr();
		tree.lrd();
	}
}
