package com.leetcode.arrayTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Embrace
 * @Classname FindClosestElements
 * @Description findClosestElements
 * @Date 2022/8/25 21:55
 * @git: https://github.com/embarce
 */
public class FindClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<Integer>();
        for (int num : arr) {
            list.add(num);
        }
        Collections.sort(list, (a, b) -> {
            if (Math.abs(a - x) != Math.abs(b - x)) {
                return Math.abs(a - x) - Math.abs(b - x);
            } else {
                return a - b;
            }
        });
        List<Integer> ans = list.subList(0, k);
        Collections.sort(ans);
        return ans;
    }
}
