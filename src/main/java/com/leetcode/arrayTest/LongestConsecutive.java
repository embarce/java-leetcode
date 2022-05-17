package com.leetcode.arrayTest;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;

/**
 * @author Embrace
 * git: https://gitee.com/EmbraceQAQ
 * @version 1.0
 * @since JDK 1.8
 * Date: 2022/5/17 10:23
 * Description: 最长连续子序列
 * FileName: LongestConsecutive
 */
public class LongestConsecutive {

    /**
     * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
     * <p>
     * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [100,4,200,1,3,2]
     * 输出：4
     * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
     * 示例 2：
     * <p>
     * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
     * 输出：9
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/longest-consecutive-sequence
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        Arrays.sort(nums);
        int res = 1;
        int tmp = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]==nums[i-1]) {
                continue;
            }
            if(nums[i]==nums[i-1]+1){
                tmp++;
            }else {
                res=Math.max(res,tmp);
                tmp=1;
            }
        }
        return res;
    }

}
