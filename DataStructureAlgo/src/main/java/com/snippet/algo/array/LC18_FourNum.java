package com.snippet.algo.array;

import java.util.*;

/**
 * create by whr on 2023-06-28
 */
public class LC18_FourNum {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (null == nums || nums.length < 1) {
            return ans;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (target > 0 && nums[i] > target) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1, right = nums.length - 1;
                while (left < right) {
                    int sum = nums[left] + nums[right] + nums[i] + nums[j];
                    if (sum == target) {
                        ans.add(List.of(nums[left], nums[right], nums[i], nums[j]));
                        left = incrementLeft(nums, left, right);
                        right = decrementRight(nums, left, right);
                    } else if (sum < target) {
                        left = incrementLeft(nums, left, right);
                    } else {
                        right = decrementRight(nums, left, right);
                    }
                }
            }
        }
        return ans;
    }

    private static int decrementRight(int[] nums, int left, int right) {
        right--;
        while (left < right && nums[right + 1] == nums[right]) {
            right--;
        }
        return right;
    }

    private static int incrementLeft(int[] nums, int left, int right) {
        left++;
        while (left < right && nums[left - 1] == nums[left]) {
            left++;
        }
        return left;
    }

    public List<List<Integer>> fourSum1(int[] nums, int target) {
        return new AbstractList<List<Integer>>() {
            List<List<Integer>> list = null;

            public List<Integer> get(int index) {
                init();
                return list.get(index);
            }

            public int size() {
                init();
                return list.size();
            }

            private void init() {
                if (list != null) {
                    return;
                }
                final Set<List<Integer>> listSet = new HashSet<>();
                Arrays.sort(nums);
                for (int i = 0; i < nums.length - 3; i++) {
                    for (int j = nums.length - 1; j > i + 2; j--) {
                        int l = i + 1;
                        int r = j - 1;
                        while (l < r) {
                            long m = (long) nums[i] + (long) nums[j] + (long) nums[l] + (long) nums[r];
                            if (m == target) {
                                listSet.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                                l++;
                                r--;
                            } else if (m > target) {
                                r--;
                            } else {
                                l++;
                            }
                        }
                    }
                }
                list = new ArrayList<>(listSet);
            }

        };
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = fourSum(new int[]{-2, -1, -1, 1, 1, 2, 2}, 0);
    }
}
