package com.ayanami.leetcode.binarysearch;

public class _153_FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        //最后一个数一定在最小值及的右侧
        int n=nums.length;
        int left=-1;
        int right=n-1;//把right一开始定义成n也行 只是在[2,1]这种最小值在n-1位置的数组条件下，right要比定义成n-1少移动一次
        while(left+1<right){
            int mid=(right-left)/2+left;
            if(nums[mid]>nums[n-1]){
                //比最右侧还大，说明最小值肯定在当前中值的右侧
                left=mid;
            }else{
                right=mid;
            }
        }
        return nums[right];

    }
}
