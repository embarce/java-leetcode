package com.leetcode.mid;

/**
 * @author Embrace
 * git: https://github.com/embarce
 * @version 1.0
 * @since JDK 1.8
 * Date: 2022/6/7 10:27
 * Description: 爱吃香蕉的珂珂
 * FileName: MinEatingSpeed
 */
public class MinEatingSpeed {

    /**
     * 二分法
     * @param piles
     * @param h
     * @return
     */
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        /**
         * 取右边界
         */
        for (int pile : piles) {
            high = Math.max(high, pile);
        }
        int k = high;
        while (low < high) {
            /**
             * 二分
             */
            int speed = (high - low) / 2 + low;
            long time = getTime(piles, speed);
            if (time <= h) {
                k = speed;
                high = speed;
            } else {
                low = speed + 1;
            }
        }
        return k;
    }

    /**
     * 时间
     * @param piles
     * @param speed
     * @return
     */
    public long getTime(int[] piles, int speed) {
        long time = 0;
        for (int pile : piles) {
            int curTime = (pile + speed - 1) / speed;
            time += curTime;
        }
        return time;
    }
}
