package com.ayanami.leetcode.heap;

import java.util.Arrays;
import java.util.Random;

public class _215_KthLargestElementInAnArray {
    private static final Random rand=new Random();//整个程序从头到尾只有一个Random对象，且不会被修改
    public int findKthLargest(int[] nums, int k) {
        return quickSele(nums,k);

    }
    public int quickSele(int[]nums,int k){
        //随机定一个基准值
        int base=nums[rand.nextInt(nums.length)];
        //将数组过滤为三组
        int[] big=Arrays.stream(nums).filter(n->n>base).toArray();
        int[] equal=Arrays.stream(nums).filter(n->n==base).toArray();
        int[] small= Arrays.stream(nums).filter(n->n<base).toArray();
        //如果k小于大数组个数，说明k就在这个里面
        if(k<=big.length){
            return quickSele(big,k);
        }else if(k<=big.length+equal.length){
            return base;
        }else{
            return quickSele(small,k-big.length-equal.length);
        }

    }
}
