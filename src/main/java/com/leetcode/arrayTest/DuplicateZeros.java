package com.leetcode.arrayTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Embrace
 * git: https://github.com/embarce
 * @version 1.0
 * @since JDK 1.8
 * Date: 2022/6/17 9:54
 * Description:  1089. 复写零
 * FileName: DuplicateZeros
 */
public class DuplicateZeros {


    /**
     * 给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
     *
     * 注意：请不要在超过该数组长度的位置写入元素。
     *
     * 要求：请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。
     *
     * 示例 1：
     *
     * 输入：[1,0,2,3,0,4,5,0]
     * 输出：null
     * 解释：调用函数后，输入的数组将被修改为：[1,0,0,2,3,0,0,4]
     * 示例 2：
     *
     * 输入：[1,2,3]
     * 输出：null
     * 解释：调用函数后，输入的数组将被修改为：[1,2,3]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/duplicate-zeros
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param arr
     */
    public void duplicateZeros(int[] arr) {
        List<Integer> list=new ArrayList<>();
        for (int i : arr) {
            list.add(i);
            if(i==0){
                list.add(i);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i]=list.get(i);
        }
    }


    /**
     * 官方双指针
     * @param arr
     */
    public void duplicateZerosDouble(int[] arr) {
        int n = arr.length;
        int top = 0;
        int i = -1;
        /**
         * 获取总的数字数量
         */
        while (top < n) {
            i++;
            if (arr[i] != 0) {
                top++;
            } else {
                top += 2;
            }
        }
        int j = n - 1;
        /**
         * 如果越界
         */
        if (top == n + 1) {
            arr[j] = 0;
            j--;
            i--;
        }
        /**
         * 从后面开始放入，i也是在后面开始计算
         */
        while (j >= 0) {
            arr[j] = arr[i];
            j--;
            if (arr[i] == 0) {
                arr[j] = arr[i];
                j--;
            }
            i--;
        }
    }

}
