package com.leetcode.arrayTest;

import java.util.Arrays;

/**
 * @author Embrace
 * git: https://gitee.com/EmbraceQAQ
 * @version 1.0
 * @since JDK 1.8
 * Date: 2022/5/20 10:01
 * Description: 寻找最右区间
 * FileName: FindRightInterval
 */
public class FindRightInterval {


    /**
     * 436. 寻找右区间
     * 给你一个区间数组 intervals ，其中 intervals[i] = [starti, endi] ，且每个 starti 都 不同 。
     *
     * 区间 i 的 右侧区间 可以记作区间 j ，并满足 startj >= endi ，且 startj 最小化 。
     *
     * 返回一个由每个区间 i 的 右侧区间 的最小起始位置组成的数组。如果某个区间 i 不存在对应的 右侧区间 ，则下标 i 处的值设为 -1 。
     *
     *
     * 示例 1：
     *
     * 输入：intervals = [[1,2]]
     * 输出：[-1]
     * 解释：集合中只有一个区间，所以输出-1。
     * 示例 2：
     *
     * 输入：intervals = [[3,4],[2,3],[1,2]]
     * 输出：[-1,0,1]
     * 解释：对于 [3,4] ，没有满足条件的“右侧”区间。
     * 对于 [2,3] ，区间[3,4]具有最小的“右”起点;
     * 对于 [1,2] ，区间[2,3]具有最小的“右”起点。
     * 示例 3：
     *
     * 输入：intervals = [[1,4],[2,3],[3,4]]
     * 输出：[-1,2,-1]
     * 解释：对于区间 [1,4] 和 [3,4] ，没有满足条件的“右侧”区间。
     * 对于 [2,3] ，区间 [3,4] 有最小的“右”起点。
     * @param intervals
     * @return
     */
    public static int[] findRightInterval(int[][] intervals) {
        int [] res =new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            int starti = intervals[i][0];
            int endi = intervals[i][1];
            if(starti==endi){
                res[i]=i;
                continue;
            }
            boolean isMark=false;
            int lastStartj=Integer.MAX_VALUE;
            for (int j = 0; j < intervals.length; j++) {
                if(i==j){
                    continue;
                }
                int startj = intervals[j][0];
                int endj = intervals[j][1];
                if(startj>=endi){
                    isMark=true;
                    if(startj<lastStartj){
                        lastStartj=startj;
                        res[i]=j;
                    }
                }
            }
            if(!isMark){
                res[i]=-1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] intervals =new int[][] {{3,4},{2,3},{1,2}};
        int[] rightInterval = findRightInterval(intervals);
        for (int i = 0; i < rightInterval.length; i++) {
            System.out.println(rightInterval[i]);
        }
    }
}
