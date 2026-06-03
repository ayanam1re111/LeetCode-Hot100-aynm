package com.ayanami.leetcode.techniques;

public class _169_MajorityElement {
    public int majorityElement(int[] nums) {
        int candidate=0;
        int count=0;
        //主要思想：超过数组长度一半的数一定会抵消掉其他树作为candidate时候的count计数，最后的candidate一定是众数
        for(int num:nums){
            if(count==0){
                candidate=num;

            }
            count+= (num==candidate ? 1:-1);
        }
        return candidate;
    }
}
