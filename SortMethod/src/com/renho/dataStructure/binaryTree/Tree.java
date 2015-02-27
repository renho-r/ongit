package com.renho.dataStructure.binaryTree;

public class Tree {

	private Node root;

	public Node find(int key) {
		Node current = root;
		while (current.iData != key) {
			if (current.iData > key) {
				current = current.leftChild;
			} else {
				current = current.rigthChild;
			}
			if (current == null) {
				return null;
			}
		}
		return current;
	}

	public void insert(int id, double data) {
		Node newNode = new Node();
		newNode.iData = id;
		newNode.fData = data;
		if (root == null) {
			root = newNode;
		} else {
			Node current = root;
			Node parent;
			while (true) {
				parent = current;
				if (current.iData > id) {
					current = current.leftChild;
					if (current == null) {
						parent.leftChild = newNode;
						return;
					}
				} else {
					current = current.rigthChild;
					if (current == null) {
						parent.rigthChild = newNode;
						return;
					}
				}
			}
		}
	}

	public void delete(int id) {
		Node current = root;
		Node parent = root;
		boolean flag = true;
		while (current.iData != id) {
			parent = current;
			if (current.iData > id) {
				current = current.leftChild;
				flag = true;
			} else {
				current = current.rigthChild;
				flag = false;
			}
			if (current == null) {
				System.out.println("没找到节点!");
			}
		}
		if (current.leftChild == null && current.rigthChild == null) {
			if (flag) {
				parent.leftChild = null;
			} else {
				parent.rigthChild = null;
			}
		}
	}

	public void ldr() {
		inOrder(root);
	}

	private void inOrder(Node node) {
		if (node == null) {
			return;
		}
		inOrder(node.leftChild);
		System.out.println("访问" + node.iData);
		inOrder(node.rigthChild);
	}
}
