package com.leetcode.arrayTest;

import java.util.*;

/**
 * @author Embrace
 * @Classname FrequencySort
 * @Description 1636. 按照频率将数组升序排序
 * @Date 2022/9/19 22:41
 * @git: https://github.com/embarce
 */
public class FrequencySort {

    /**
     * 给你一个整数数组 nums ，请你将数组按照每个值的频率 升序 排序。如果有多个值的频率相同，请你按照数值本身将它们 降序 排序。
     * <p>
     * 请你返回排序后的数组。
     *
     * @param nums
     * @return
     */
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        for (int num : nums) {
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        }
        List<Integer> list = new ArrayList<Integer>();
        for (int num : nums) {
            list.add(num);
        }
        Collections.sort(list, (a, b) -> {
            int cnt1 = cnt.get(a), cnt2 = cnt.get(b);
            return cnt1 != cnt2 ? cnt1 - cnt2 : b - a;
        });
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            nums[i] = list.get(i);
        }
        return nums;
    }

}
