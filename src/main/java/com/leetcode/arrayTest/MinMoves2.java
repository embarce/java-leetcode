package com.leetcode.arrayTest;

import java.util.Arrays;

/**
 * @author Embrace
 * git: https://gitee.com/EmbraceQAQ
 * @version 1.0
 * @since JDK 1.8
 * Date: 2022/5/19 9:54
 * Description: 最少移动次数使数组元素相等 II
 * FileName: MinMoves2
 */
public class MinMoves2 {

    /**
     * 给你一个长度为 n 的整数数组 nums ，返回使所有数组元素相等需要的最少移动数。
     *
     * 在一步操作中，你可以使数组中的一个元素加 1 或者减 1 。
     *
     * 示例 1：
     *
     * 输入：nums = [1,2,3]
     * 输出：2
     * 解释：
     * 只需要两步操作（每步操作指南使一个元素加 1 或减 1）：
     * [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
     * 示例 2：
     *
     * 输入：nums = [1,10,2,9]
     * 输出：16
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/minimum-moves-to-equal-array-elements-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public int minMoves2(int[] nums) {
        /**
         * 排序
         */
        Arrays.sort(nums);
        int res=0;
        int length = nums.length;
        /**
         * 取中间值
         */
        int mid = nums[length/2];
        /**
         * 大变小，小变大，贪心最佳
         */
        for (int i = 0; i < nums.length; i++) {
            res+=Math.abs(nums[i]-mid);
        }
        return res;
    }
    /**
     * 执行用时：
     * 4 ms
     * , 在所有 Java 提交中击败了
     * 74.85%
     * 的用户
     * 内存消耗：
     * 42.1 MB
     * , 在所有 Java 提交中击败了
     * 30.30%
     * 的用户
     * 通过测试用例：
     * 30 / 30
     */
}
