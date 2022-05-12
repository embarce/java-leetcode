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
 * Date: 2022/5/11 14:07
 * Description: 中序遍历
 * FileName: Inorder
 */
public class Inorder {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        inorder(root,list);
        return list;
    }

    /**
     * 递归 左根右
     * @param root
     * @param res
     */
    public void inorder(TreeNode root , List<Integer> res){
        if(root==null){
            return;
        }
        inorder(root.left,res);
        res.add(root.val);
        inorder(root.right,res);
    }

    /**
     * 迭代   用一个栈维护了上级变量，让他先下去再慢慢上来
     * @param root
     * @param res
     */
    public void inorderByIterate(TreeNode root , List<Integer> res){
        if(root==null){
            return;
        }
        Stack<TreeNode> stack=new Stack<>();
        while (!stack.isEmpty() || root!=null){
            while (root!=null){
                stack.push(root);
                root=root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root=root.right;
        }
    }
}
