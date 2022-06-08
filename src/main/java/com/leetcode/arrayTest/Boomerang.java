package com.leetcode.arrayTest;

/**
 * @author Embrace
 * git: https://github.com/embarce
 * @version 1.0
 * @since JDK 1.8
 * Date: 2022/6/8 9:50
 * Description: 回旋镖
 * FileName: Boomerang
 */
public class Boomerang {

    /**
     * 给定一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点，如果这些点构成一个 回旋镖 则返回 true 。
     * <p>
     * 回旋镖 定义为一组三个点，这些点 各不相同 且 不在一条直线上 。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：points = [[1,1],[2,3],[3,2]]
     * 输出：true
     * 示例 2：
     * <p>
     * 输入：points = [[1,1],[2,2],[3,3]]
     * 输出：false
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/valid-boomerang
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param points
     * @return
     */
    public static boolean isBoomerang(int[][] points) {
        if (points.length < 3) {
            return false;
        }
        int x1 = points[0][0];
        int y1 = points[0][1];
        int x2 = points[1][0];
        int y2 = points[1][1];
        int x3 = points[2][0];
        int y3 = points[2][1];
        /**
         * 去掉没有斜率的情况
         */
        if (x1 == x2 && x2 == x3 && y1 == y2 && y2 == y3) {
            return false;
        }
        if (x1 == x2 && x2 == x3) {
            return false;
        }
        if ((x1 == x2 && y1 == y2) || (x2 == x3 && y2 == y3)) {
            return false;
        }
        /**
         * 垂直的情况
         */
        if (x1 == x2) {
            return true;
        }
        if (x2 == x3) {
            return true;
        }
        /**
         * 重合点位情况
         */
        if (y1 == y2 && y2 == y3) {
            return false;
        }
        double k1 = (double) (y1 - y2) / (x1 - x2);
        double k2 = (double) (y2 - y3) / (x2 - x3);
        /**
         * 斜率相等 在一条直线
         */
        if (k2 == k1) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        /**
         * [[0,1],[1,0],[1,1]]
         * [[0,1],[2,1],[0,0]]
         * [[0,1],[1,1],[2,1]]
         * [[92,72],[12,40],[27,46]]
         */
        System.out.println(isBoomerang(new int[][]{{92, 72}, {12, 40}, {27, 46}}));
    }
}
