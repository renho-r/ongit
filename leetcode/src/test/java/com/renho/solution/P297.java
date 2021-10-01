package com.renho.solution;

import com.renho.model.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author renho
 * @date 2021/6/29
 */
public class P297 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        Codec codec = new Codec();
        codec.deserialize(codec.serialize(root));
    }
}

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (null == root) {
            return null;
        }
        return serializePre(root).toString();
    }

    public StringBuilder serializePre(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if(null == root) {
            return sb.append("null");
        }
        sb.append(root.val).append(",");
        sb.append(serialize(root.left)).append(",");
        sb.append(serialize(root.right));
        return sb;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] datas = data.split(",");
        LinkedList<String> datass = new LinkedList();
        for (int i=0; i<datas.length; i++) {
            datass.addLast(datas[i]);
        }
        return deserializePre(datass);
    }

    public TreeNode deserializePre(LinkedList<String> datas) {

        if (datas.isEmpty()) {
            return null;
        }
        String rootValue = datas.removeFirst();
        if ("null".equals(rootValue))  {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(rootValue));
        root.left = deserializePre(datas);
        root.right = deserializePre(datas);
        return root;
    }
}