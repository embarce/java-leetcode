package com.leetcode.arrayTest;

import java.util.Arrays;

/**
 * @author Embrace
 * git: https://github.com/embarce
 * @version 1.0
 * @since JDK 1.8
 * Date: 2022/6/1 9:52
 * Description: 火柴正方形
 * FileName: Makesquare
 */
public class Makesquare {
    /**
     * 你将得到一个整数数组 matchsticks ，其中 matchsticks[i] 是第 i 个火柴棒的长度。你要用 所有的火柴棍 拼成一个正方形。你 不能折断 任何一根火柴棒，但你可以把它们连在一起，而且每根火柴棒必须 使用一次 。
     * <p>
     * 如果你能使这个正方形，则返回 true ，否则返回 false 。
     * <p>
     * 输入: matchsticks = [1,1,2,2,2]
     * 输出: true
     * 解释: 能拼成一个边长为2的正方形，每边两根火柴。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/matchsticks-to-square
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param matchsticks
     * @return
     */
    public static boolean makesquare(int[] matchsticks) {
        if (matchsticks.length < 4) {
            return false;
        }
        /**
         * 计算总的长度
         */
        int sum = 0;
        for (int matchstick : matchsticks) {
            sum += matchstick;
        }
        /**
         * 确认是否可以平均分成4个
         */
        if (sum % 4 != 0){
            return false;
        }
        Arrays.sort(matchsticks);
        return allocate(matchsticks,matchsticks.length-1,new int[4],sum/4);
    }

    /**
     * 抽象为4个水桶，一根一根挑取火柴
     * @param matchsticks
     * @param index
     * @param sums
     * @param avg
     * @return
     */
    public static boolean allocate(int[] matchsticks, int index, int[] sums, int avg) {
        if (index == -1) {
            return sums[0] == avg && sums[1] == avg && sums[2] == avg && sums[3]==avg;
        }
        /**
         * 4个水桶都去尝试接火柴
         */
        for (int i = 0; i < 4; ++i) {
            /**
             * 装不下
             */
            if (sums[i] + matchsticks[index] > avg) {
                continue;
            }
            /**
             * 装得下
             */
            sums[i] += matchsticks[index];
            /**
             * 用递归去装第二根火柴
             */
            if (allocate(matchsticks, index - 1, sums, avg)) {
                return true;
            }
            /**
             * 他第二根不行，回退到刚才选的，吐出火柴
             */
            sums[i] -= matchsticks[index];
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(makesquare(new int[]{5,5,5,5,4,4,4,4,3,3,3,3}));
    }
}
