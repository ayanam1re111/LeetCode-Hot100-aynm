package com.ayanami.leetcode.binarytree;

public class _226_InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        //终止条件
        if(root==null){
            return null;
        }
        //交换
        TreeNode left=invertTree(root.left);
        TreeNode right=invertTree(root.right);
        root.left=right;
        root.right=left;
        return root;

    }
}
