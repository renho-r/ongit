/**   
* @Title: Tree.java 
* @Package com.renho 
* @Description: TODO
* @author renho   
* @date 2013年9月4日 下午2:44:57 
* @version V1.0   
*/
package com.renho.testone;

import com.renho.Node;

public class Tree {

	private Node root;
	
	/**
	 * find key
	 * @param key
	 * @return
	 */
	public Node find(int key) {
		Node current = root;
		while(key != current.iData) {
			if(current.iData > key) {
				current = current.leftChild;
			}else {
				current = current.rightChild;
			}
			if (current == null) {
				return null;
			}
		}
		return current;
	}
	
	/**
	 * 插入
	 * @param id
	 * @param data
	 */
	public void insert(int id, double data) {
		Node newNode = new Node();
		newNode.iData = id;
		newNode.fData = data;
		if(null == root) {
			root = newNode;
		}else {
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
					current = current.rightChild;
					if (current == null) {
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}
	
	/**
	 * 删除，不完整
	 * @param id
	 */
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
	
	/**
	 * 中序遍历
	 */
	public void ldr() {
		inOrder(root);
	}

	private void inOrder(Node node) {
		if (node == null) {
			return;
		}
		inOrder(node.leftChild);
		System.out.println("访问" + node.iData);
		inOrder(node.rightChild);
	}
	/**
	 * 前序遍历
	 */
	public void dlr() {
		dlrOrder(root);
	}
	private void dlrOrder(Node node) {
		if (node == null) {
			return;
		}
		System.out.println("访问" + node.iData);
		dlrOrder(node.leftChild);
		dlrOrder(node.rightChild);
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
}

