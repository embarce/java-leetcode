package com.leetcode.arrayTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Embrace
 * git: https://github.com/embarce
 * @version 1.0
 * @since JDK 1.8
 * Date: 2022/7/28 20:58
 * Description:1331. 数组序号转换
 * FileName: ArrayRankTransform
 */
public class ArrayRankTransform {

    public static void main(String[] args) {
        arrayRankTransform(new int[] {37,12,28,9,100,56,80,5,12});
    }

    public static int[] arrayRankTransform(int[] arr) {
        Map<Integer,Integer> map =new HashMap<>();
        int[] ints = Arrays.copyOf(arr, arr.length);
        Arrays.sort(ints);
        int tmp = 1;
        for (int i = 0; i < ints.length; i++) {
            if(map.containsKey(ints[i])){
                continue;
            }
            map.put(ints[i],tmp);
            tmp++;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i]=map.get(arr[i]);
        }
        return arr;
    }
}
