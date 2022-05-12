package com.leetcode.tree;

import com.leetcode.vo.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Embrace
 * git: https://gitee.com/EmbraceQAQ
 * @version 1.0
 * @since JDK 1.8
 * Date: 2022/5/12 10:14
 * Description: 中序前序构建2叉树
 * FileName: BuildTree
 */
public class BuildTree {

    /**
     * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
     * 输出: [3,9,20,null,null,15,7]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param preorder
     * @param inorder
     * @return
     */
    Map<Integer,Integer> inorderIndexMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderIndexMap=new HashMap<>();
        int length = inorder.length;
        for (int i = 0; i < length; i++) {
            inorderIndexMap.put(inorder[i],i);
        }
        return buildChildTree(preorder,0,length-1,0);
    }

    public TreeNode buildChildTree(int[] preorder,int preLeft,int preRight,int inLeft){
        /**
         * 递归退出条件------括号收敛到不能在收了
         */
        if(preLeft>preRight){
            return null;
        }
        /**
         * 前序第一个必然是根
         */
        int rootVal = preorder[preLeft];
        /**
         * 定位根节点
         */
        Integer rootIndex = inorderIndexMap.get(rootVal);
        /**
         * 中序获取他的左子树数量
         */
        int inorderLeftSum = rootIndex - inLeft;
        /**
         * 构建根节点
         */
        TreeNode root=new TreeNode(rootVal);
        /**
         * 构建左子树 左括号+1到左子树的根节点，右括号到左子树的最后（左前+数量），中序指针不变
         * 找到了index，确定inorder中左右子树的边界
         * 最终确认好preorder和inorder中的左右子树边界
         */
        root.left=buildChildTree(preorder,preLeft+1,preLeft+inorderLeftSum,inLeft);
        /**
         * 构建右子树 左括号到右子树的第一个节点（左前+数量+1），右括号不变，中序指针变为根节点+1
         * 找到了index，确定inorder中左右子树的边界
         * 最终确认好preorder和inorder中的左右子树边界
         */
        root.right=buildChildTree(preorder,preLeft+1+inorderLeftSum,preRight,rootIndex+1);
        return root;
    }
}
