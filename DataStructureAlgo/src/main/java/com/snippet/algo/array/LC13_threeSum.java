package com.snippet.algo.array;

import java.util.*;

/**
 * create by whr on 2023-06-26
 */
public class LC13_threeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int target = -nums[i];
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = i + 1; j < nums.length; j++) {
                if (map.containsKey(nums[j])) {
                    add(res, new Integer[]{nums[i], nums[j], map.get(nums[j])});
                } else {
                    map.put(target - nums[j], nums[j]);
                }
            }
        }
        return res;
    }

    private void add(List<List<Integer>> list, Integer[] nums) {
        Arrays.sort(nums);
        boolean flag = true;
        for (List<Integer> subList : list) {
            for (int i = 0; i < subList.size(); i++) {
                if (!Objects.equals(subList.get(i), nums[i])) {
                    break;
                }
                if (i == 3) {
                    flag = false;
                }
            }
        }
        if (flag) {
            list.add(Arrays.asList(nums));
        }
    }
}
