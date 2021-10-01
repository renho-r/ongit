package com.renho.solution;

import java.util.Arrays;

/**
 * @author renho
 * @date 2021/6/28
 */
public class P450 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        P450 p450 = new P450();
        TreeNode result = p450.deleteNode(root, 3);
        System.out.println(result);
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (null == root) {
            return null;
        }
        if (key == root.val) {
            if (null == root.left && null == root.right) {
                return null;
            }
            if (null == root.left) {
                return root.right;
            }
            if (null == root.right) {
                return root.left;
            }
            TreeNode minNode = getMinNode(root.right);
            minNode.right = deleteNode(root.right, minNode.val);
            minNode.left = root.left;
            return minNode;
        }
        if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        }
        return root;
    }

    public TreeNode getMinNode(TreeNode root) {
        while(null != root.left) {
            root = root.left;
        }
        return root;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
