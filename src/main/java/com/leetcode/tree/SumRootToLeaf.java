package com.leetcode.tree;

import com.leetcode.vo.TreeNode;

import java.util.Stack;

/**
 * @author Embrace
 * git: https://gitee.com/EmbraceQAQ
 * @version 1.0
 * @since JDK 1.8
 * Date: 2022/5/30 10:24
 * Description: 从根到叶的二进制数之和
 * FileName: SumRootToLeaf
 */
public class SumRootToLeaf {


    /**
     * 给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。
     *
     * 例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。
     * 对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。
     *
     * 返回这些数字之和。题目数据保证答案是一个 32 位 整数。
     * 输入：root = [1,0,1,0,1,0,1]
     * 输出：22
     * 解释：(100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
     * 示例 2：
     *
     * 输入：root = [0]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/sum-of-root-to-leaf-binary-numbers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/sum-of-root-to-leaf-binary-numbers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param root
     * @return
     */
    public int sumRootToLeaf(TreeNode root) {
        int res =0 ;
        int tmp =0;
        Stack<TreeNode> stack=new Stack<>();
        TreeNode per =null;
        while (root!=null || !stack.isEmpty()){
            while (root != null) {
                tmp=tmp*2+root.val;
                stack.push(root);
                root=root.left;
            }
            root = stack.peek();
            if(root.left==root.right){
                res+=tmp;
                tmp=tmp/2;
                per=stack.pop();
                root=null;
            }else if(root.right==null || root.right==per){
                per=stack.pop();
                tmp=tmp/2;
                root=null;
            }else {
                root=root.right;
            }
        }
        return res;
    }
}
