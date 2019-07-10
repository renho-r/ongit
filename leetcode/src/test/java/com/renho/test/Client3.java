package com.renho.test;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class Client3 {

    private int count = 1;
    boolean[][] grid = new boolean[][]{
            {true, true, true, true, true, true, true, true},
            {true, true, false, true, true, true, false, true},
            {true, true, true, true, false, true, true, true},
            {false, true, false, true, true, false, true, true},
            {true, true, false, true, true, true, true, true},
            {true, true, true, false, false, true, false, true},
            {true, false, true, true, true, false, true, true},
            {true, true, true, true, true, true, true, true},
    };
    @Test
    public void mg() {

        go(grid, 0, 0);
//        dt();
        System.out.println(count);
    }

    private int[][] op = new int[grid.length][grid[0].length];
    private void dt() {
        op[grid.length-1][grid[0].length-1] = 1;
        for(int row=grid.length-1; row>=0; row--) {
            for(int col=grid[0].length-1; col>=0; col--) {
                count++;
                if(row!=grid.length-1 || col!=grid[0].length-1) {
                    if(grid[row][col]) {
                        int right = col+1>=grid[0].length? 0: op[row][col+1];
                        int down = row+1>=grid.length? 0: op[row+1][col];
                        op[row][col] = right + down;
                    } else {
                        op[row][col] = 0;
                    }
                }
            }
        }

    }
    Map<String, Integer> map = new HashMap<>();
    private int go(boolean[][] grid, int row, int col) {
        System.out.println(count++);
        if (row>=grid.length || col>=grid[0].length) {
            return 0;
        }
        if(!grid[row][col]) {
            return 0;
        }
        if(row==grid.length-1 && col==grid[0].length-1) {
            return 1;
        }
        int x = null==map.get(row + "," + (col+1))? go(grid, row, col+1): map.get(row + "," + (col+1));
        map.put(row + "," + (col+1), x);
        int y = null==map.get((row+1) + "," + col)? go(grid, row+1, col): map.get((row+1) + "," + col);
        map.put((row+1) + "," + col + "," + col, y);
        return x + y;
    }

}
