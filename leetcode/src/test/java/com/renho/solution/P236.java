package com.renho.solution;

import com.renho.model.TreeNode;
import org.junit.Test;

import java.util.List;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class P236 {

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
        lowestCommonAncestor(root, root.left.left, root.right.right);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(null==root || root==p || root==q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left == null) {
            return right;
        }

        if(right == null) {
            return left;
        }
        return root;
    }
}
