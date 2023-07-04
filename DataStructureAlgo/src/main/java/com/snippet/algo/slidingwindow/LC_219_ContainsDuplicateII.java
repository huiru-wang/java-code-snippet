package com.snippet.algo.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * ??????????
 * <p>
 * create by whr on 2023/3/22
 */
public class LC_219_ContainsDuplicateII {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && Math.abs(map.get(nums[i]) - i) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }

}
