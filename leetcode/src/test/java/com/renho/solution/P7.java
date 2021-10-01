package com.renho.solution;

import java.util.LinkedList;

/**
 * @author renho
 * @date 2021/7/1
 */
public class P7 {

    public static void main(String[] args) {
        System.out.println(5/3);
        System.out.println(0 % 2);
        int[][]relation = new int[][]{new int[]{0, 2}, {2, 1}, {3, 4}, {2, 3}, {1, 4}, {2, 0}, {0, 4}};
//        int[][] relation = new int[][]{{2,0}, {0,1}, {1,2}, {1,0}, {2,1}, {0,2}};
        P7 p7 = new P7();
        System.out.println(p7.numWays(5, relation, 3));
    }

    public int numWays(int n, int[][] relation, int k) {
        return dp(n, relation, k, 0);
    }

    public int dp(int n, int[][] relation, int k, int pName) {
        if (0 == k && (n-1) == pName) {
            return 1;
        } else if (0 == k && (n-1) != pName){
            return 0;
        }
        int count = 0;
        for (int j=0; j<relation.length; j++) {
            if (relation[j][0] == pName) {
                count += dp(n, relation, k - 1, relation[j][1]);
            }
        }
        return count;
    }
}
