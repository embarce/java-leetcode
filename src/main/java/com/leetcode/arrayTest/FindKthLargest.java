package com.leetcode.arrayTest;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Embrace
 * git: https://github.com/embarce
 * @version 1.0
 * @since JDK 1.8
 * Date: 2022/6/10 10:42
 * Description: 215. 数组中的第K个最大元素
 * FileName: FindKthLargest
 */
public class FindKthLargest {


    /**
     * 215. 数组中的第K个最大元素
     * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
     * <p>
     * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     * <p>
     * 输入: [3,2,1,5,6,4] 和 k = 2
     * 输出: 5
     * <p>
     * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
     * 输出: 4
     * <p>
     * 1 <= k <= nums.length <= 104
     * -104 <= nums[i] <= 104
     *
     * @param nums
     * @param k
     * @return
     */
    public static  int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return - o1.compareTo(o2);
            }
        });
        for (int i = 0; i < nums.length; i++) {
            queue.offer(nums[i]);
        }
        for (int i = 0; i < k-1; i++) {
            queue.poll();
        }
        return queue.peek();
    }


    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[] {3,2,1,5,6,4},2));
    }
}
