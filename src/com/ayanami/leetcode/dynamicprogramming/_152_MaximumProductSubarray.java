package com.ayanami.leetcode.dynamicprogramming;

public class _152_MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int max=Integer.MIN_VALUE;
        int tempMax=1;
        int tempMin=1;
        //因为负数的存在，所以说要额外维护一个当前最小值
        for(int i:nums){
            if(i<0){//如果遇到负数，二者交换
                int temp=tempMax;
                tempMax=tempMin;
                tempMin=temp;
            }

            tempMax=Math.max(i,tempMax*i);
            tempMin=Math.min(i,tempMin*i);

            //全局最大值
            max=Math.max(max,tempMax);

        }

        return max;

    }
}
