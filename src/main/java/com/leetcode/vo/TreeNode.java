package com.leetcode.vo;

/**
 * @author Embrace
 * git: https://gitee.com/EmbraceQAQ
 * @version 1.0
 * @since JDK 1.8
 * Date: 2022/5/11 10:31
 * Description:
 * FileName: TreeNode
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x, TreeNode left, TreeNode right) {
        this.val = x;
        this.left=left;
        this.right=right;
    }

    public TreeNode(int x) {
        this.val = x;
    }
}
