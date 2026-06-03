package com.ayanami.leetcode.techniques;

public class _031_NextPermutation {
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        if(n==1){
            return;
        }
        int r=n;
        //123465
        //先从后往前找第一个升序
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                r=i+1;
                break;
            }
        }


        //如果r=n，说明是降序，直接升序排
        if(r==n){
            reverse(nums,0,n-1);
        }

        //找[r,n-1]中第一个大于int[r-1]的数，交换
        for(int j=n-1;j>=r;j--){
            if(nums[j]>nums[r-1]){

                swap(nums,j,r-1);
                //此时[r,n-1]为降序，将其改为升序
                reverse(nums,r,n-1);
                break;
            }

        }



    }
    //用于交换两元素位置
    private void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    //用于翻转数组为升序(优化Arrays.sort时间)
    private void reverse(int[] nums, int start,int end){
        while(start<end){
            swap(nums,start,end);
            start++;
            end--;
        }


    }
}
