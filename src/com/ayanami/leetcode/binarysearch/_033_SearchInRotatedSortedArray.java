package com.ayanami.leetcode.binarysearch;

public class _033_SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int n=nums.length;
        //找到最小元素索引，也就是两段分割处
        int i=findMin(nums);
        //如果target大于最后一个数，那么target一定在(-1,i)中
        if(target>nums[n-1]){
            return lowerBound(nums,-1,i,target);
        }else{//如果target小于等于最后一个数，那么一定在(i-1,n)中
            return lowerBound(nums,i-1,n,target );
        }

    }
    public int findMin(int[] nums){
        int n=nums.length;
        //用中间值和最后一个数字做比较
        int left=-1;
        int right=n-1;
        while(left+1<right){
            int mid=(left+right)>>>1;
            //如果中间值大于最后一个数，那么最小值一定在中间值右边
            if(nums[mid]>nums[n-1]){//因为题目给定数组无重复，不会出现=情况，所以写>和>=没有区别
                left=mid;
            }else{
                right=mid;
            }
        }
        return right;

    }
    public int lowerBound(int[] nums,int left,int right,int target){
        while(left+1<right){
            int mid=(left+right)>>>1;
            if(nums[mid]>=target){
                right=mid;
            }else{
                left=mid;
            }
        }
        return nums[right]==target ? right:-1;
    }
}
/**不能改成if(nums[mid]>target){
 right=mid;
 }else{
 left=mid;
 }
 }
 return nums[left]==target ? left:-1;的原因：
 虽然这里数据元素不重复 <=target 和>=target的边界没区别，
 但是left如果在 【456012】 target=3这种情况下 开区间写法left是-1，会报空指针异常
 而right，如果在前半区间，right索引一定不越界，如果在后半区间，因为一开始就判断了target<=最后一个元素，
 所以无论如何right也会踩在最后一个元素 不会越界 */

