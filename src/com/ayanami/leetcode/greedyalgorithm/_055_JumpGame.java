package com.ayanami.leetcode.greedyalgorithm;

public class _055_JumpGame {
    public boolean canJump(int[] nums) {
        //遍历并算最远距离，只要当前位置在最远距离内，就可以计算该位置下的最远距离，在最远距离达到最后一个索引时返回true
        int des=0;
        int len=nums.length;
        for(int i=0;i<len;i++){
            if(i<=des){
                des=Math.max(nums[i]+i,des);

                if(des>=len-1){
                    return true;
                }
            }

        }
        return false;

    }
}
