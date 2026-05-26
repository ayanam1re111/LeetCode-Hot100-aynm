package com.ayanami.leetcode.dynamicprogramming;

public class _198_HouseRobber {
    public int rob(int[] nums) {
        //dp[k-2]
        int prev=0;
        //dp[k-1]
        int cur=0;

        for(int i:nums){
            //选择[0,k-2]+k或者[0,k-1]
            int temp=Math.max(prev+i,cur);
            prev=cur;
            cur=temp;
        }

        return cur;

    }
}
