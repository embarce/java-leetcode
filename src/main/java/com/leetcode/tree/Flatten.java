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
 * Date: 2022/5/16 10:29
 * Description: 树展开为链表
 * FileName: Flatten
 */
public class Flatten {

    /**
     * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
     *
     * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
     * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
     * 输入：root = [1,2,5,3,4,null,6]
     * 输出：[1,null,2,null,3,null,4,null,5,null,6]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/flatten-binary-tree-to-linked-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param root
     */
    public void flatten(TreeNode root) {
        iterateTreeNode(root);
    }

    /**
     * 迭代算法，通过数组储存节点
     * @param root
     */
    public void iterateTreeNode(TreeNode root){
        List<TreeNode> treeNodes=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        while (!stack.isEmpty()||root!=null){
            while (root!=null){
                treeNodes.add(root);
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            root=root.right;
        }
        for (int i = 1; i < treeNodes.size(); i++) {
            TreeNode per = treeNodes.get(i - 1);
            TreeNode cur = treeNodes.get(i);
            per.left=null;
            per.right=cur;
        }
    }


    /**
     * 不适用数组加入  只有在前节点不为空的情况才能变 先把右节点入，再到左节点，后入先出
     * @param root
     */
    public void iterateTreeNodeAtTheSameTime(TreeNode root){
        if(root==null){
            return;
        }
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        TreeNode per=null;
        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            if(per!=null){
                per.left=null;
                per.right=pop;
            }
            if(pop.right!=null){
                stack.push(pop.right);
            }
            if(pop.left!=null){
                stack.push(pop.left);
            }
            per=pop;
        }
    }

    /**
     * 原地算法   很有趣的算法，类似于剪枝
     * 先用两个指针指向根的左节点，
     * predecessor指针往右子树一直遍历到底下后把根节点的右子树剪下来，
     * 放到predecessor的右子树，把根节点的左设为空，右变为next指针
     * 再把curr指针往右遍历
     * @param root
     */
    public void inSitu(TreeNode root){
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode next = curr.left;
                TreeNode predecessor = next;
                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                predecessor.right = curr.right;
                curr.left = null;
                curr.right = next;
            }
            curr = curr.right;
        }
    }
}
