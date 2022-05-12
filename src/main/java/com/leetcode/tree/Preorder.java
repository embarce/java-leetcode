package com.leetcode.tree;


import com.leetcode.vo.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Embrace
 * git: https://gitee.com/EmbraceQAQ
 * @version 1.0
 * @since JDK 1.8
 * Date: 2022/5/11 14:22
 * Description: 前序遍历
 * FileName: Preorder
 */
public class Preorder {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        preorder(root,res);
        return res;
    }

    /**
     * 递归 根左右
     * @param root
     * @param res
     */
    public void preorder(TreeNode root ,List<Integer> res){
        if(root==null){
            return;
        }
        res.add(root.val);
        preorder(root.left,res);
        preorder(root.right,res);
    }


    /**
     * 迭代   内部维护一个栈，每次往下时先记录值，然后再下去，到底再吐出旧值然后去右孩子
     * @param root
     * @param res
     */
    public void preorderByIterate(TreeNode root ,List<Integer> res){
        if(root==null){
            return;
        }
        Stack<TreeNode> stack=new Stack<>();
        while (!stack.isEmpty() || root!=null){
            while (root!=null){
                stack.push(root);
                res.add(root.val);
                root=root.left;
            }
            root=stack.pop().right;
        }
    }
}
