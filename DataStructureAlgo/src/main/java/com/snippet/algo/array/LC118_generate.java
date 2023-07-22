package com.snippet.algo.array;

import java.util.ArrayList;
import java.util.List;

/**
 * create by whr on 2023-07-18
 */
public class LC118_generate {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        ans.add(list);
        int level = 1;
        while (level < numRows) {
            List<Integer> cur = new ArrayList<>();
            cur.add(1);
            List<Integer> upper = ans.get(level - 1);
            for (int i = 1; i < level; i++) {
                int left = upper.get(i - 1);
                int right = upper.get(i);
                cur.add(left + right);
            }
            cur.add(1);
            ans.add(cur);
            level++;
        }
        return ans;
    }

}
