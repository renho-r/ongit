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
public class P104 {

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
        int result = maxDepth(root);
        System.out.println(result);
    }

    private int max = 0;

    public int maxDepth(TreeNode root) {
        return null==root? 0: Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    private void dep(TreeNode root, int dep) {
        if(null==root.left && null==root.right) {
            if(dep > max) {
                max = dep;
            }
        }
        if(null != root.left) {
            dep(root.left, dep + 1);
        }
        if(null != root.right) {
            dep(root.right, dep + 1);
        }
    }

}
