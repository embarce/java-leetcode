package com.leetcode.arrayTest;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author Embrace
 * @Classname TrimMean
 * @Description TODO
 * @Date 2022/9/14 20:43
 * @git: https://github.com/embarce
 */
public class TrimMean {

    /**
     * 给你一个整数数组 arr ，请你删除最小 5% 的数字和最大 5% 的数字后，剩余数字的平均值。
     *
     * 与 标准答案 误差在 10-5 的结果都被视为正确结果。
     * @param arr
     * @return
     */
    public double trimMean(int[] arr) {
        int length = arr.length;
        int number = (int) (length*0.05);
        Arrays.sort(arr);
        int end = length - number;
        int sum =0 ;
        for (int i = number; i < end; i++) {
            sum+=arr[i];
        }
        return sum/(length * 0.9);
    }
}
