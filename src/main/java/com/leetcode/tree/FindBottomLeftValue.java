package com.leetcode.tree;

import com.leetcode.vo.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Embrace
 * git: https://github.com/embarce
 * @version 1.0
 * @since JDK 1.8
 * Date: 2022/6/22 10:20
 * Description: 513. 找树左下角的值
 * FileName: FindBottomLeftValue
 */
public class FindBottomLeftValue {

    /**
     * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
     *
     * 假设二叉树中至少有一个节点。
     * 示例 1:
     * 输入: root = [2,1,3]
     * 输出: 1
     * 示例 2:
     * 输入: [1,2,3,4,null,5,6,null,null,7]
     * 输出: 7
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/find-bottom-left-tree-value
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param root
     * @return
     */
    public int findBottomLeftValue(TreeNode root) {
        int tag = root.val;
        /**
         * 搜索队列
         */
        Queue<TreeNode> queue=new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            /**
             * 队列取值
             */
            TreeNode poll = queue.poll();
            /**
             * 从右边开始放入搜素队列--层序遍历往下
             */
            if(poll.right!=null){
                queue.offer(poll.right);
            }
            if(poll.left!=null){
                queue.offer(poll.left);
            }
            /**
             * 最后的就是值
             */
            tag=poll.val;
        }
        return tag;
    }
}
