package com.renho.solution;

/**
 * @author renho
 * @date 2021/6/26
 */
public class P322 {

    public static void main(String[] args) {
        int[] coins = new int[] {1, 2, 5};
        int amount = 100;
        System.out.println(coinChange(coins, amount));
    }

    public static int coinChange(int[] coins, int amount) {
        System.out.printf("cal %d \n", amount);
        if(0 == amount) {
            return 0;
        }
        if(amount < 0) {
            return -1;
        }
        int minCount = Integer.MAX_VALUE;
        for (int i=0; i<coins.length; i++) {
            int subCount = coinChange(coins, amount - coins[i]);
            if (-1 == subCount) {
                continue;
            }
            minCount = minCount<subCount + 1? minCount: subCount + 1;
        }
        return minCount==Integer.MAX_VALUE? -1: minCount;
    }

}
