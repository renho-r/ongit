package com.renho.solution;

import com.renho.model.TreeNode;
import org.junit.Test;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class P102 {

    @Test
    public void test() {

        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);

        List<List<Integer>> result = levelOrder(treeNode);
        System.out.println(result);
    }

//    public List<List<Integer>> levelOrder(TreeNode root) {
//        if(null==root) {
//            return new ArrayList();
//        }
//        List<List<Integer>> result = new ArrayList<>();
//        LinkedList<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        while(!queue.isEmpty()) {
//            List<TreeNode> thisLevelNode = new ArrayList<>();
//            List<Integer> thisLevelVal = new ArrayList<>();
//            while(!queue.isEmpty()) {
//                TreeNode thisNode = queue.pollFirst();
//                thisLevelVal.add(thisNode.val);
//                TreeNode leftNode = thisNode.left;
//                TreeNode rightNode = thisNode.right;
//                if(null != leftNode) {
//                    thisLevelNode.add(leftNode);
//                }
//                if(null != rightNode) {
//                    thisLevelNode.add(rightNode);
//                }
//            }
//            queue.addAll(thisLevelNode);
//            result.add(thisLevelVal);
//        }
//        return result;
//    }

//    public List<List<Integer>> levelOrder(TreeNode root) {
//        if(null==root) {
//            return new ArrayList();
//        }
//        List<List<Integer>> result = new ArrayList<>();
//        LinkedList<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        while(!queue.isEmpty()) {
//            List<Integer> thisLevelVal = new ArrayList<>();
//            int thisLevelCount = queue.size();
//            for(int i=0; i<thisLevelCount; i++) {
//                TreeNode thisNode = queue.pollFirst();
//                thisLevelVal.add(thisNode.val);
//                TreeNode leftNode = thisNode.left;
//                TreeNode rightNode = thisNode.right;
//                if(null != leftNode) {
//                    queue.add(leftNode);
//                }
//                if(null != rightNode) {
//                    queue.add(rightNode);
//                }
//            }
//            result.add(thisLevelVal);
//        }
//        return result;
//    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(null==root) {
            return new ArrayList();
        }
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }

    private void dfs(TreeNode root, int dep, List<List<Integer>> result) {
        if(result.size() < dep + 1) {
            result.add(dep, new ArrayList<Integer>());
        }
        if(null != root.left) {
            dfs(root.left, dep + 1, result);
        }
        if(null != root.right) {
            dfs(root.right, dep + 1, result);
        }
        if(null == result.get(dep)) {
            result.add(dep, new ArrayList<Integer>());
        }
        result.get(dep).add(root.val);
    }

}
