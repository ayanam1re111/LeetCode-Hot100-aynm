package com.ayanami.leetcode.binarytree;

public class _098_ValidateBinarySearchTree {
    //全局变量pre用于记录上一个遍历到的节点值
    private long pre=Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        //递归遍历左子树
        if(!isValidBST(root.left)){
            return false;
        }
        //处理当前根节点
        //当节点值小于上一个节点值，违反递增，false
        if(root.val<=pre){
            return false;
        }
        //校验通过，更新pre为当前节点值
        pre=root.val;

        //递归遍历右子树
        return isValidBST(root.right);


    }

}
