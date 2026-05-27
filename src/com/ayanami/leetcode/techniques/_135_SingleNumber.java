package com.ayanami.leetcode.techniques;

public class _135_SingleNumber {
    public int singleNumber(int[] nums) {
        int ans=0;
        for(int n:nums){
            ans ^=n;
        }
        return ans;

    }
}
