package com.renho.solution;

import java.util.*;

/**
 * @author renho
 * @date 2021/7/3
 */
public class P451 {

    public static void main(String[] args) {
        P451 p451 = new P451();
//        String s = "tree";
        String s = "Aabb";
//        System.out.println(p451.frequencySort(s));

        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<100; i++) {
            map.put(i, i);
        }
//        new ArrayList(map.keySet()).forEach(k -> {
//            map.remove(k);
//        });
        map.keySet().forEach(k -> {
            map.remove(k);
        });

        System.out.println(map.size());
        StringBuilder sb = new StringBuilder();
    }

    public String frequencySort(String s) {
        Map<Character, Node> map = new HashMap();
        List<Node> sort = new LinkedList();
        for(int i=0; i<s.length(); i++) {
            Character c = s.charAt(i);
            Node node = map.getOrDefault(c, new Node(c, 0));
            sort.remove(node);
            node.count = node.count + 1;
            map.put(c, node);
            sort.add(node);
        }
        Collections.sort(sort);
        StringBuilder sb = new StringBuilder();
        sort.forEach(node -> {
            for (int i=0; i<node.count; i++) {
                sb.append(node.c);
            }
        });
        return sb.toString();
    }

    class Node implements Comparable<Node> {

        private Character c;
        private int count;
        public Node(Character c, int count) {
            this.c = c;
            this.count = count;
        }

        @Override
        public int compareTo(Node o) {
            if (this.c.equals(o.c)) {
                return 0;
            }
            return this.count > o.count? -1: 1;
        }
    }
}
