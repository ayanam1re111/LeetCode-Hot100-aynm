package com.ayanami.leetcode.dynamicprogramming;

public class _070_ClimbingStairs {
    public int climbStairs(int n) {
        //dp[k-2]
        int prev=1;//初始：从第零层走到第一层
        //dp[k-1]
        int cur=1;//第一层走到第二层
        for(int i=2;i<=n;i++){
            //直接相加即可是因为加入f(4)=f(3)+f(2),第三层到第四层只有跨一步这一种方法，所以提供了f(3)种方法，
            //而到达第二层后先走一层再走一层的方法数被f(3)包括了，f(2)实际上只能通过一次两步到达第四层，所以提供了f(2)种方法
            int temp=prev+cur;
            prev=cur;
            cur=temp;
        }
        return cur;

    }
}
