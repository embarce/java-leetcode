package com.leetcode.arrayTest;

/**
 * @author Embrace
 * @Classname NumSpecial
 * @Description 1582. 二进制矩阵中的特殊位置
 * @Date 2022/9/4 18:16
 * @git: https://github.com/embarce
 */
public class NumSpecial {

    public int numSpecial(int[][] mat) {
        int res=0;
        for (int i = 0; i < mat.length; i++) {
            int rowSum=0;
            int clSum=0;
            int clIndex=0;
            for (int j = 0; j < mat[i].length; j++) {
                rowSum+=mat[i][j];
                if(mat[i][j]==1){
                    clIndex=j;
                }
            }
            if(rowSum== 1){
                for (int k = 0; k < mat.length; k++) {
                    clSum+=mat[k][clIndex];
                }
                if(clSum==1){
                     res++;
                }
            }
        }
        return res;
    }
}
