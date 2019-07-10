package com.renho.solution;

import com.renho.model.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class P98 {

    @Test
    public void test() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.left.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        isValidBST(root);
    }

    private TreeNode pre;

    public boolean isValidBST(TreeNode root) {
        return midTest(root);
    }

    private boolean midTest(TreeNode root) {
        if(null == root) {
            return true;
        }
        if (!midTest(root.left)) {
            return false;
        }
        if(null!=pre && root.val<=pre.val) {
            return false;
        }
        this.pre = root;
        return midTest(root.right);
    }

    public void inorder(TreeNode root, List<Integer> result) {
        if(null != root.left) {
            inorder(root.left, result);
        }
        result.add(root.val);
        if(null != root.right) {
            inorder(root.right, result);
        }
    }

    public void border(TreeNode root, List<Integer> result) {
        result.add(root.val);
        if(null != root.left) {
            border(root.left, result);
        }
        if(null != root.right) {
            border(root.right, result);
        }
    }

    public void aorder(TreeNode root, List<Integer> result) {
        if(null != root.left) {
            aorder(root.left, result);
        }
        if(null != root.right) {
            aorder(root.right, result);
        }
        result.add(root.val);
    }
}
