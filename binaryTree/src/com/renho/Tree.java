/**   
* @Title: Tree.java 
* @Package com.renho 
* @Description: TODO
* @author renho   
* @date 2013年9月4日 下午4:19:19 
* @version V1.0   
*/
package com.renho;

public class Tree {
	private Node root;
	
	public void insert(int id, int data) {
		Node node = new Node();
		node.iData = id;
		node.fData = data;
		if(root == null) {
			root = node;
		}else {
			Node current = root;
			Node parent;
			while(true) {
				parent = current;
				if(current.iData > id) {
					current = current.leftChild;
					if (current == null) {
						parent.leftChild = node;
						return;
					}
				}else {
					current = current.rightChild;
					if (current == null) {
						parent.rightChild = node;
						return;
					}
				}
			}
		}
	}
	
	/**
	 * 后序遍历
	 */
	public void lrd() {
		lrdOrder(root);
	}
	private void lrdOrder(Node node) {
		if (node == null) {
			return;
		}
		lrdOrder(node.leftChild);
		lrdOrder(node.rightChild);
		System.out.println("访问" + node.iData);
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
				current = current.rightChild;
				flag = false;
			}
			if (current == null) {
				System.out.println("没找到节点!");
			}
		}
		if (current.leftChild == null && current.rightChild == null) {
			if (flag) {
				parent.leftChild = null;
			} else {
				parent.rightChild = null;
			}
		}
	}
}

