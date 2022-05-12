package com.leetcode.strTest;

/**
 * @author Embrace
 * git: https://gitee.com/EmbraceQAQ
 * @version 1.0
 * @since JDK 1.8
 * Date: 2022/5/12 9:51
 * Description:
 * FileName: MinDeletionSize
 */
public class MinDeletionSize {

    /**
     * 给你由 n 个小写字母字符串组成的数组 strs，其中每个字符串长度相等。
     *
     * 这些字符串可以每个一行，排成一个网格。例如，strs = ["abc", "bce", "cae"] 可以排列为：
     *
     * abc
     * bce
     * cae
     * 你需要找出并删除 不是按字典序升序排列的 列。在上面的例子（下标从 0 开始）中，列 0（'a', 'b', 'c'）和列 2（'c', 'e', 'e'）都是按升序排列的，而列 1（'b', 'c', 'a'）不是，所以要删除列 1 。
     *
     * 返回你需要删除的列数。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：strs = ["cba","daf","ghi"]
     * 输出：1
     * 解释：网格示意如下：
     *   cba
     *   daf
     *   ghi
     * 列 0 和列 2 按升序排列，但列 1 不是，所以只需要删除列 1 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/delete-columns-to-make-sorted
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param strs
     * @return
     */
    public static int minDeletionSize(String[] strs) {
        int res =0;
        char[][] map=new char[strs.length][strs[0].length()];
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] chars = str.toCharArray();
            for (int j = 0; j < chars.length; j++) {
                map[i][j]=chars[j];
            }
        }
        int list = map[0].length;
        int row = map.length;
        for (int i = 0; i < list; i++) {
            for (int j = 1; j < row; j++) {
                if (map[j-1][i]>map[j][i]) {
                    res++;
                    break;
                }
            }
        }
        return res;

    }

    public static void main(String[] args) {
        String[] strings={"zyx","wvu","tsr"};
        int i = minDeletionSize(strings);
        System.out.println(i);
    }
}
