package com.ayanami.leetcode.binarysearch;

public class _035_SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        //不管目标值是否存在于数组，最后right踩的位置都是目标值应在的位置
        //开区间（left,right）
        int left=-1;
        int right=nums.length;
        while((left+1)!=right){
            int mid=(right-left)/2+left;
            if(nums[mid]>=target){
                right=mid;//如果是等于，right也直接踩上去，等于说从right开始向右的不再需要验证，一定>=target
            }else{
                left=mid;
            }
        }
        //直到left+1=right再出循环，此时由于题目规定nums一定不为空数组，left一定<target,right一定是>=target的边界
        return right;
    }

}
