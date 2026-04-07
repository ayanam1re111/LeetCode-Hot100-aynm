package com.ayanami.leetcode.arrayproblems;

public class _238_ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] ans=new int[nums.length];
        ans[0]=1;

        int temp=1;
        //第一个循环：得出每个数左侧的乘积
        for(int i=1;i<nums.length;i++){
            ans[i]=ans[i-1]*nums[i-1];
        }
        //第二个循环：将每个数左侧乘积乘上右侧乘积
        for(int i=nums.length-2;i>=0;i--){
            temp*=nums[i+1];
            ans[i]*=temp;
        }
        return ans;



    }
}
