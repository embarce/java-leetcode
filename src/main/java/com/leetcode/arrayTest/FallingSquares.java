package com.leetcode.arrayTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Embrace
 * git: https://gitee.com/EmbraceQAQ
 * @version 1.0
 * @since JDK 1.8
 * Date: 2022/5/26 10:00
 * Description: 699. 掉落的方块
 * FileName: FallingSquares
 */
public class FallingSquares {
    /**
     * 在无限长的数轴（即 x 轴）上，我们根据给定的顺序放置对应的正方形方块。
     * <p>
     * 第 i 个掉落的方块（positions[i] = (left, side_length)）是正方形，其中 left 表示该方块最左边的点位置(positions[i][0])，side_length 表示该方块的边长(positions[i][1])。
     * <p>
     * 每个方块的底部边缘平行于数轴（即 x 轴），并且从一个比目前所有的落地方块更高的高度掉落而下。在上一个方块结束掉落，并保持静止后，才开始掉落新方块。
     * <p>
     * 方块的底边具有非常大的粘性，并将保持固定在它们所接触的任何长度表面上（无论是数轴还是其他方块）。邻接掉落的边不会过早地粘合在一起，因为只有底边才具有粘性。
     * <p>
     * <p>
     * 返回一个堆叠高度列表 ans 。每一个堆叠高度 ans[i] 表示在通过 positions[0], positions[1], ..., positions[i] 表示的方块掉落结束后，目前所有已经落稳的方块堆叠的最高高度。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [[1, 2], [2, 3], [6, 1]]
     * 输出: [2, 5, 5]
     * 解释:
     * <p>
     * 第一个方块 positions[0] = [1, 2] 掉落：
     * _aa
     * _aa
     * -------
     * 方块最大高度为 2 。
     * <p>
     * 第二个方块 positions[1] = [2, 3] 掉落：
     * __aaa
     * __aaa
     * __aaa
     * _aa__
     * _aa__
     * --------------
     * 方块最大高度为5。
     * 大的方块保持在较小的方块的顶部，不论它的重心在哪里，因为方块的底部边缘有非常大的粘性。
     * <p>
     * 第三个方块 positions[1] = [6, 1] 掉落：
     * __aaa
     * __aaa
     * __aaa
     * _aa
     * _aa___a
     * --------------
     * 方块最大高度为5。
     * <p>
     * 因此，我们返回结果[2, 5, 5]。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/falling-squares
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param positions
     * @return
     */
    public static List<Integer> fallingSquares(int[][] positions) {
        int n = positions.length;
        List<Integer> heights = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            int left1 = positions[i][0], right1 = positions[i][0] + positions[i][1] - 1;
            int height = positions[i][1];
            for (int j = 0; j < i; j++) {
                int left2 = positions[j][0], right2 = positions[j][0] + positions[j][1] - 1;
                if (right1 >= left2 && right2 >= left1) {
                    height = Math.max(height, heights.get(j) + positions[i][1]);
                }
            }
            heights.add(height);
        }
        for (int i = 1; i < n; i++) {
            heights.set(i, Math.max(heights.get(i), heights.get(i - 1)));
        }
        return heights;
    }

    /**
     * 我写的超出内存了，原来可以用时间替换空间，我靠，你看上面
     * @param positions
     * @return
     */
    public static List<Integer> fallingSquaresMyAns(int[][] positions) {
        int len = 0;
        for (int i = 0; i < positions.length; i++) {
            int i1 = positions[i][0];
            int i2 = positions[i][1];
            len = Math.max(i1 + i2, len);
        }
        int[] x = new int[len + 1];
        int maxY=0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < positions.length; i++) {
            int xIndex = positions[i][0];
            int xLen = positions[i][1];
            int yHigh =0;
            for (int j = 0; j <= xLen; j++) {
                x[xIndex+j]=x[xIndex+j]+xLen;
                yHigh=Math.max(yHigh,x[xIndex+j]);
            }
            for (int j = 0; j <= xLen; j++) {
                x[xIndex+j]=yHigh;
            }
            maxY=Math.max(yHigh,maxY);
            res.add(maxY);
        }
        return res;
    }

    public static void main(String[] args) {
        int [] [] p=new int[][] {{100,100},{200,100}};
        System.out.println(fallingSquares(p));
    }
}
