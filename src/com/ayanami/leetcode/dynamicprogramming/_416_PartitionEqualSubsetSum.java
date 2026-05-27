package com.ayanami.leetcode.dynamicprogramming;

public class _416_PartitionEqualSubsetSum {
    // "归"的直观理解
/*
从头开始，一个个数字处理:先看第 1 个数 → 再看前 2 个 → 再看前 3 个…直到看完所有数。
对每一个数字，都算一遍：能不能凑出 j = 0、1、2、3…s/2
把结果存在表格 f[i][j] 里。
后面的计算，直接用前面算好的结果,不用重复算！
比如算前 3 个数，直接拿前 2 个数的结果推。
最后答案：用全部 nums.length 个数，能不能凑出 s/2
对应表格：f[n][s/2]
*/
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int i:nums){
            sum+=i;
        }
        if(sum%2!=0){
            return false;
        }
        sum=sum/2;
        //f就约等于递归中的memo
        boolean[][] f=new boolean[n+1][sum+1];//+1是为了容纳前0个 f[0][0]=true,这样后续的才能进行累加计算
        f[0][0]=true;

        for(int i=0;i<n;i++){//这里的i代表索引，f[k]是代表前k个，k=i+1,因为有第0个（什么都不选，和为0）存在
            for(int j=0;j<=sum;j++){
                int a=nums[i];
                f[i+1][j]=(a<=j && f[i][j-a]) || f[i][j];//选或不选，先判断a<=j是防止负数索引越界
            }
        }

        return f[n][sum];//最终返回前n个数中能否找到和为sum的组合

    }
}
