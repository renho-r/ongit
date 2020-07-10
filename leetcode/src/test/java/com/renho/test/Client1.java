package com.renho.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class Client1 {

    @Test
    public void test() {
        Set<Integer> ss = new HashSet<>();
        ss.add(1);
        ss.add(3);
        ss.add(5);
        ss.add(7);
        ss.add(11);
        ss.add(13);
        ss.add(17);
        ss.add(19);

        Set<Integer> used = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        for (int i=2; i<=20; i++) {
            dfs(0, result, ss, used, i);
        }
    }

    private void dfs(int index, List<Integer> result, Set<Integer> ss, Set<Integer> used, int count) {

        for(int j=1; j<=count; j++) {
            if(used.contains(j)) {
                continue;
            }
            if(index>0 && !ss.contains(j+result.get(index-1))) {
                continue;
            }
            if (index == (count - 1)) {
                if (ss.contains(j+result.get(0))) {
                    result.add(index, j);
                    System.out.println(result.toString());
                    result.remove(index);
                }
                break;
            }
            result.add(index, j);
            used.add(j);
            dfs(index+1, result, ss, used, count);
            result.remove(index);
            used.remove(j);
        }

    }

}
