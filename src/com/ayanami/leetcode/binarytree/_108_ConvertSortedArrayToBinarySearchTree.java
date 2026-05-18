package com.ayanami.leetcode.binarytree;

public class _108_ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return connect(nums,0,nums.length-1);

    }
    private TreeNode connect(int nums[],int left,int right){
        //终止条件
        if(left>right){
            return null;
        }
        //根据左右索引找到中点或中间偏左的点作为（根）节点
        int mid=(left+right)/2;
        TreeNode root=new TreeNode(nums[mid]);
        //左右递归
        root.left=connect(nums,left,mid-1);
        root.right=connect(nums,mid+1,right);
        return root;
    }
}
