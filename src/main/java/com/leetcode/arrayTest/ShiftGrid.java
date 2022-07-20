package com.leetcode.arrayTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Embrace
 * git: https://github.com/embarce
 * @version 1.0
 * @since JDK 1.8
 * Date: 2022/7/20 20:06
 * Description:
 * FileName: ShiftGrid
 */
public class ShiftGrid {

    /**
     * 1260. 二维网格迁移
     * 给你一个 m 行 n 列的二维网格 grid 和一个整数 k。你需要将 grid 迁移 k 次。
     *
     * 每次「迁移」操作将会引发下述活动：
     *
     * 位于 grid[i][j] 的元素将会移动到 grid[i][j + 1]。
     * 位于 grid[i][n - 1] 的元素将会移动到 grid[i + 1][0]。
     * 位于 grid[m - 1][n - 1] 的元素将会移动到 grid[0][0]。
     * 请你返回 k 次迁移操作后最终得到的 二维网格。
     *
     * 输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
     * 输出：[[9,1,2],[3,4,5],[6,7,8]]
     *
     * 输入：grid = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
     * 输出：[[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]
     *
     * 输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 9
     * 输出：[[1,2,3],[4,5,6],[7,8,9]]
     * @param grid
     * @param k
     * @return
     */
    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int [][] tmp = new int[m][1];
        for (int i = 0; i < m; i++) {
            tmp[i][0]=grid[i][0];
        }
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < m; j++) {
                for (int t = 0; t < n; t++) {
                    int tmpInt = grid[j][t];
                    grid[j][t]=tmp[j][0];
                    tmp[j][0] = tmpInt;
                }
            }
            for (int b = 1; b < m; b++) {
                grid[b][0]=tmp[b-1][0];
            }
            grid[0][0]=tmp[m-1][0];
        }
        List<List<Integer>> res= new ArrayList<>();
        for (int j = 0; j < m; j++) {
            List<Integer> list=new ArrayList<>();
            for (int t = 0; t < n; t++) {
                list.add(grid[j][t]);
            }
            res.add(list);
        }
        return res;
    }

    public static void main(String[] args) {
        int [][] tmp = {{3,8,1,9},{19,7,2,5},{4,6,11,10},{12,0,21,13}};
        shiftGrid(tmp,4);
    }

}
