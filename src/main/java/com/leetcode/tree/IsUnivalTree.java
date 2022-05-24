package com.leetcode.tree;

import com.leetcode.vo.TreeNode;

import java.util.Stack;

/**
 * @author Embrace
 * git: https://gitee.com/EmbraceQAQ
 * @version 1.0
 * @since JDK 1.8
 * Date: 2022/5/24 9:50
 * Description: 单值二叉树
 * FileName: IsUnivalTree
 */
public class IsUnivalTree {



    public static boolean isUnivalTree(TreeNode root) {
        if(root==null){
            return true;
        }
        int lastVal=-1;
        Stack<TreeNode> stack=new Stack<>();
        while (!stack.isEmpty()||root!=null){
            while (root!=null){
                stack.push(root);
                if(lastVal==-1){
                    lastVal=root.val;
                }else {
                    if(root.val!=lastVal){
                        return false;
                    }
                }
                root=root.left;
            }
            root = stack.pop();
            root=root.right;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isUnivalTree(new TreeNode(0,null,null)));
    }
}
