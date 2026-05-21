package com.ayanami.leetcode.binarysearch;

public class _034_FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        //start相当于找>=target的最低边界
        int start=lowerBound(nums,target);
        //除去数组为空或者目标值不在nums中的情况
        if(start==nums.length || nums[start]!=target){//仅验证start即可，start正确end一定正确且存在
            //不能直接
            return new int[]{-1,-1};
        }else{
            //end是找<=target的最高边界，相当于>target的最低边界-1,也就是>=target+1的最低边界-1
            int end=lowerBound(nums,target+1)-1;
            return new int[]{start,end};
        }

    }
    public int lowerBound(int[] nums,int target){
        int left=-1;
        int right=nums.length;
        while(left+1!=right){
            int mid=(right-left)/2+left;
            if(nums[mid]>=target){
                right=mid;
            }else{
                left=mid;
            }
        }
        return right;
    }
}
