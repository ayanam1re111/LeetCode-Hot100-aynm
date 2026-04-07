package com.ayanami.leetcode.arrayproblems;

public class _53_MaximumSubarray {
    public int maxSubArray(int[] nums){
        int ans=nums[0];
        int sum=0;
        int[] s=new int[nums.length];//输入数组中到每一个位置为止最大的连续累加和
        s[0]=nums[0];
        if(nums.length>1){
            for(int i=1;i<nums.length;i++){
                if(s[i-1]<=0){
                    s[i]=nums[i];
                }else{

                    s[i]=s[i-1]+nums[i];
                }
                ans=Math.max(ans,s[i]);
            }}
        return ans;}
}
