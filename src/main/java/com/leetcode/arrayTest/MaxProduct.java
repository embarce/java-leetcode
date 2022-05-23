package com.leetcode.arrayTest;

/**
 * @author Embrace
 * git: https://gitee.com/EmbraceQAQ
 * @version 1.0
 * @since JDK 1.8
 * Date: 2022/5/23 10:12
 * Description:
 * FileName: MaxProduct
 */
public class MaxProduct {

    /**
     * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
     *
     * 测试用例的答案是一个 32-位 整数。
     *
     * 子数组 是数组的连续子序列。
     *
     * 示例 1:
     *
     * 输入: nums = [2,3,-2,4]
     * 输出: 6
     * 解释: 子数组 [2,3] 有最大乘积 6。
     * 示例 2:
     *
     * 输入: nums = [-2,0,-1]
     * 输出: 0
     * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/maximum-product-subarray
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public static int maxProduct(int[] nums) {
        int res=0;
        if(nums.length==1){
            return nums[0];
        }
        for (int i = 0; i < nums.length; i++) {
            int tmp=1;
            for (int j = i; j < nums.length; j++) {
                tmp=tmp*nums[j];
                if(res<tmp){
                    res=tmp;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{2,3,-2,4}));
    }
}
