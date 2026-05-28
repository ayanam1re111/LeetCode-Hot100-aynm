package com.ayanami.leetcode.dynamicprogramming;

public class _300_LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[] f=new int[n];//初始值为0
        int ans=0;


        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    f[i]=Math.max(f[i],f[j]);//循环中的f[i]就是到索引为i的数之前，最长连续递增数列，如果前面都是递减，那么f[i]未被赋值，依旧为0，最后自增1代表数组仅有其本身
                }
            }
            ans=Math.max(ans,++f[i]);


        }
        return ans;

    }
}
