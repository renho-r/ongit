package com.renho.solution;

import org.junit.Test;

import java.util.*;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class P51 {

    @Test
    public void test() {

        System.out.println(solveNQueens(14).size());
    }

    Map<Integer, String> MAP_STR = new HashMap();

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        if(1 == n) {
            result.add(Arrays.asList("Q"));
            return result;
        }
        Set<Integer> cols = new HashSet<>();
        Set<Integer> pie = new HashSet<>();
        Set<Integer> na = new HashSet<>();
        dfs(n, 0, cols, pie, na, new ArrayList(), result);
        return result;
    }

    private void dfs(int n, int row, Set<Integer> cols, Set<Integer> pie, Set<Integer> na, List<String> cur, List<List<String>> result) {

        if(row >= n) {
            result.add(new ArrayList(cur));
            return;
        }

        for(int col=0; col<n; col++) {
            if(cols.contains(col) || pie.contains(col + row) || na.contains(col - row)) {
                continue;
            }
            cur.add(get(col, n));
            cols.add(col);
            pie.add(col + row);
            na.add(col - row);
            dfs(n, row + 1, cols, pie, na, cur, result);
            cur.remove(cur.size() - 1);
            cols.remove(col);
            pie.remove(col + row);
            na.remove(col - row);
        }

    }

    private String get(int col, int n) {
        if(MAP_STR.containsKey(col)) {
            return MAP_STR.get(col);
        }
        String result = "";
        for(int i=0; i<n; i++) {
            if(i == col) {
                result += "Q";
            } else {
                result += ".";
            }
        }
        MAP_STR.put(col, result);
        return result;
    }

}
