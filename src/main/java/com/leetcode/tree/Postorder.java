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
 * Date: 2022/5/11 14:32
 * Description: 后序遍历
 * FileName: Postorder
 */
public class Postorder {


    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        postorder(root,res);
        return res;
    }

    /**
     * 递归 左右根
     * @param root
     * @param res
     */
    public void postorder(TreeNode root,List<Integer> res){
        if(root==null){
            return;
        }
        postorder(root.left,res);
        postorder(root.right,res);
        res.add(root.val);
    }


    /**
     * 后序遍历迭代
     * 这个和前中序都不一样有点意思
     * 这个首先让他一直往下走，然后回到上级，
     * 判断他右边是不是为空不为空 且 之前有没有去过，
     * 去过就加入到答案序列，没有就进入把旧指针改为右节点
     * @param root
     * @param res
     */
    public void postorderByIterate(TreeNode root ,List<Integer> res){
        if(root==null){
            return;
        }
        Stack<TreeNode> stack=new Stack<>();
        TreeNode per=null;
        while (!stack.isEmpty() || root!=null){
            while (root!=null){
                stack.push(root);
                root=root.left;
            }
            root=stack.peek();
            if(root.right==null || root.right==per){
                res.add(root.val);
                per=root;
                root=null;
            }else {
                root=root.right;
            }
        }
    }

}
