package com.ayanami.leetcode.arrayproblems;

public class _041_FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int n=nums.length;

        for(int i=0;i<n;i++){
            while(nums[i]>0 && nums[i]<=n && nums[nums[i]-1]!=nums[i]){
                swap(nums,nums[i]-1,i);//必须要穿第二个参数，因为在swap过程中num[i]会变
            }
        }
        //遍历检查位置不对的
        for(int j=0;j<n;j++){
            if(nums[j]!=j+1){
                return j+1;
            }

        }
        return n+1;


    }

    private void swap(int[] nums,int idx1,int idx2){
        int temp=nums[idx2];
        nums[idx2]=nums[idx1];
        nums[idx1]=temp;

    }
}
