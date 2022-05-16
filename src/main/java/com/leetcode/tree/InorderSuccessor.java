package com.leetcode.tree;

import com.leetcode.vo.TreeNode;
import org.apache.poi.ss.formula.functions.T;

import java.util.Stack;

/**
 * @author Embrace
 * git: https://gitee.com/EmbraceQAQ
 * @version 1.0
 * @since JDK 1.8
 * Date: 2022/5/16 9:57
 * Description: 二叉搜索树中序遍历的下一个节点
 * FileName: InorderSuccessor
 */
public class InorderSuccessor {

    /**
     * 设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
     *
     * 如果指定节点没有对应的“下一个”节点，则返回null。
     *
     * 示例 1:
     *
     * 输入: root = [2,1,3], p = 1
     *
     *   2
     *  / \
     * 1   3
     *
     * 输出: 2
     * 示例 2:
     *
     * 输入: root = [5,3,6,2,4,null,null,1], p = 6
     *
     *       5
     *      / \
     *     3   6
     *    / \
     *   2   4
     *  /
     * 1
     *
     * 输出: null
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/successor-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param root
     * @param p
     * @return
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode per=null;
        Stack<TreeNode> stack=new Stack<>();
        while (!stack.isEmpty() || root!=null){
            while (root!=null){
                stack.push(root);
                root=root.left;
            }
            TreeNode pop = stack.pop();
            if(p==per){
                return pop;
            }
            per=pop;
            root=pop.right;
        }
        return null;
    }


    /**
     * 2分查找
     * 当前节点比目标节点大，那就往下面的左子树找
     * 当前节点比目标节点小或等于 去下面的右子树找
     * @param root
     * @param p
     * @return
     */
    public TreeNode inorderSuccessorSeach(TreeNode root, TreeNode p){
        int target=p.val;
        TreeNode cur=root;
        TreeNode res=null;
        while (cur!=null){
            if(cur.val>target){
                res=cur;
                cur=cur.left;
            }else {
                cur=cur.right;
            }
        }
        return res;
    }
}
