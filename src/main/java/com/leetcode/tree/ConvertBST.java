package com.leetcode.tree;

import com.leetcode.vo.TreeNode;

/**
 * @author Embrace
 * git: https://gitee.com/EmbraceQAQ
 * @version 1.0
 * @since JDK 1.8
 * Date: 2022/5/26 10:58
 * Description:  把二叉搜索树转换为累加树
 * FileName: ConvertBST
 */
public class ConvertBST {
    /**
     * 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
     *
     * 提醒一下，二叉搜索树满足下列约束条件：
     *
     * 节点的左子树仅包含键 小于 节点键的节点。
     * 节点的右子树仅包含键 大于 节点键的节点。
     * 左右子树也必须是二叉搜索树。
     *
     * 输入：[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
     * 输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
     *
     * 输入：root = [0,null,1]
     * 输出：[1,null,1]
     *
     * 输入：root = [1,0,2]
     * 输出：[3,3,2]
     *
     * 输入：root = [3,2,4,1]
     * 输出：[7,9,4,10]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/convert-bst-to-greater-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     */
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }
}
