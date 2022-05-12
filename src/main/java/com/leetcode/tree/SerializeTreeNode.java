package com.leetcode.tree;


import com.leetcode.vo.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Embrace
 * git: https://gitee.com/EmbraceQAQ
 * @version 1.0
 * @since JDK 1.8
 * Date: 2022/5/11 10:31
 * Description: 序列化和反序列2叉树
 * FileName: SerializeTreeNode
 */
public class SerializeTreeNode {

    public static String serialize(TreeNode root) {
        if(root == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        sb.append("[");
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node == null) {
                sb.append("#,");
            } else{
                sb.append(node.val).append(",");
                queue.offer(node.left);
                queue.offer(node.right);
            }

        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("]");
        return sb.toString();
    }

    /**
     * 反序列化
     * @param data
     * @return
     */
    public static TreeNode deserialize(String data) {
        if("[]".equals(data)){
            return null;
        }
        String substring = data.substring(1, data.length() - 1);
        Queue<TreeNode> queue = new LinkedList<>();
        String[] split = substring.split(",");
        TreeNode root =new TreeNode(Integer.parseInt(split[0]));
        queue.offer(root);
        int index=1;
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            if(!"#".equals(split[index])){
                TreeNode left=new TreeNode(Integer.parseInt(split[index]));
                poll.left=left;
                queue.offer(left);
            }
            index++;
            if(!"#".equals(split[index])){
                TreeNode right=new TreeNode(Integer.parseInt(split[index]));
                poll.right=right;
                queue.offer(right);
            }
            index++;

        }
        return root;
    }



    public static void main(String[] args) {
        TreeNode treeNode4 = new TreeNode(4, null, null);
        TreeNode treeNode5 = new TreeNode(5, null, null);
        TreeNode treeNode3 = new TreeNode(3, treeNode4, null);
        TreeNode treeNode1 = new TreeNode(1, null, treeNode5);
        TreeNode treeNode2 = new TreeNode(2, treeNode1, treeNode3);
        String serialize = serialize(treeNode2);
        System.out.println(serialize);
        deserialize(serialize);
    }
}
