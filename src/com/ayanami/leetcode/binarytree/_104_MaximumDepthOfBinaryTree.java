package com.ayanami.leetcode.binarytree;

public class _104_MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        //没有节点时跳出迭代
        if(root==null){
            return 0;
        }
        //左右分别迭代到最尾端
        int left=maxDepth(root.left);
        int right=maxDepth(root.right);
        //长度等于左右较长的加上当前节点
        int ans=Math.max(left,right)+1;

        return ans;


    }
}
