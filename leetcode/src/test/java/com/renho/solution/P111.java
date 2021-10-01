package com.renho.solution;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author renho
 * @date 2021/6/27
 */
public class P111 {

    public int minDepth(TreeNode root) {
        if(null == root) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        int depth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                TreeNode cur = queue.poll();
                if (null == cur.left && null == cur.right) {
                    return depth;
                }
                if (null != cur.left) {
                    queue.offer(cur.left);
                }
                if (null != cur.right) {
                    queue.offer(cur.right);
                }
            }
            depth++;
        }
        return depth;
    }

    class TreeNode {
        TreeNode left;
        TreeNode right;
    }
}
