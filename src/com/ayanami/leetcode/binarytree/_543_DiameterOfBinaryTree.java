package com.ayanami.leetcode.binarytree;

public class _543_DiameterOfBinaryTree {
    private int ans;//将ans定义为全局变量
    public int diameterOfBinaryTree(TreeNode root) {
        count(root);
        return ans;
    }
    private int count(TreeNode root){
        if(root==null){
            return 0;
        }

        int llength=count(root.left);
        int rlength=count(root.right);
        ans=Math.max(ans,llength+rlength);//每一个节点比较
        return Math.max(llength,rlength)+1;//返回一个节点左右较长的那一条
    }
}
