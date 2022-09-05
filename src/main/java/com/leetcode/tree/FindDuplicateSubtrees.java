package com.leetcode.tree;

import com.leetcode.vo.TreeNode;

import java.util.*;

/**
 * @author Embrace
 * @Classname FindDuplicateSubtrees
 * @Description 652. 寻找重复的子树
 * @Date 2022/9/5 21:03
 * @git: https://github.com/embarce
 */
public class FindDuplicateSubtrees {
    Map<String, TreeNode> seen = new HashMap<String, TreeNode>();
    Set<TreeNode> repeat = new HashSet<TreeNode>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return new ArrayList<TreeNode>(repeat);
    }

    public String dfs(TreeNode node) {
        if (node == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(node.val);
        sb.append("(");
        sb.append(dfs(node.left));
        sb.append(")(");
        sb.append(dfs(node.right));
        sb.append(")");
        String serial = sb.toString();
        if (seen.containsKey(serial)) {
            repeat.add(seen.get(serial));
        } else {
            seen.put(serial, node);
        }
        return serial;
    }
}
