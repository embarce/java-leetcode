package com.leetcode.mid;

import java.util.*;

/**
 * @author Embrace
 * git: https://gitee.com/EmbraceQAQ
 * @version 1.0
 * @since JDK 1.8
 * Date: 2022/5/18 9:45
 * Description: 乘法表最小数字
 * FileName: FindKthNumber
 */
public class FindKthNumber {

    /**
     * 几乎每一个人都用 乘法表。但是你能在乘法表中快速找到第k小的数字吗？
     * <p>
     * 给定高度m 、宽度n 的一张 m * n的乘法表，以及正整数k，你需要返回表中第k 小的数字。
     * <p>
     * 例 1：
     * <p>
     * 输入: m = 3, n = 3, k = 5
     * 输出: 3
     * 解释:
     * 乘法表:
     * 1	2	3
     * 2	4	6
     * 3	6	9
     * <p>
     * 第5小的数字是 3 (1, 2, 2, 3, 3).
     * 例 2：
     * <p>
     * 输入: m = 2, n = 3, k = 6
     * 输出: 6
     * 解释:
     * 乘法表:
     * 1	2	3
     * 2	4	6
     * <p>
     * 第6小的数字是 6 (1, 2, 2, 3, 4, 6).
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/kth-smallest-number-in-multiplication-table
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param m
     * @param n
     * @param k
     * @return
     */
    public static int findKthNumber(int m, int n, int k) {
        int[] minHeap = new int[k];
        for (int i = 0; i < k; i++) {
            minHeap[i] = i + 1;
        }
        for (int i = 2; i <= m; i++) {
            if (i > k) {
                break;
            }
            for (int j = 1; j <= n; j++) {
                int tmp = i * j;
                int heapMaxTmp = minHeap[k - 1];
                if (tmp < heapMaxTmp) {
                    minHeap[k - 1] = tmp;
                    /**
                     * 麻了超时了
                     */
                    Arrays.sort(minHeap);
                }

            }
        }
        return minHeap[k - 1];
    }

    /**
     * 大佬的2分解法
     * @param m
     * @param n
     * @param k
     * @return
     */
    public static int findKthNumberByMid(int m, int n, int k) {
        int left = 1, right = m * n;
        while (left < right) {
            //计算x，也就是二分的mid
            int x = left + (right - left) / 2;
            int count = 0;
            //计算每一行小于等于x的个数
            for (int i = 1; i <= m; i++) {
                count += Math.min(x / i, n);
            }
            //二分法查找第k小
            if (count >= k) {
                right = x;
            } else {
                left = x + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(findKthNumberByMid(9895, 28405, 100787757));
    }
}
