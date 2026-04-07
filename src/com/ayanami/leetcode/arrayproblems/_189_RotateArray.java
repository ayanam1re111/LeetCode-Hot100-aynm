package com.ayanami.leetcode.arrayproblems;

public class _189_RotateArray {

        public void rotate(int[] nums, int k) {
            int[] ans=new int[nums.length];
            for (int i=0;i<nums.length;i++){
                if(i>=nums.length-k){
                    ans[i+k-nums.length]=nums[i];
                }else{
                    ans[i+k]=nums[i];
                }
            }
            for (int i=0;i<nums.length;i++){
                nums[i]=ans[i];
            }


        }
}
