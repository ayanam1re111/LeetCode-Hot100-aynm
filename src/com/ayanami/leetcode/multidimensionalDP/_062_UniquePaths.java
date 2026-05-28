package com.ayanami.leetcode.multidimensionalDP;

import java.util.Arrays;

public class _062_UniquePaths {
    //第一列永远是1，不会动，所以直接从第一行第一列传下来即可，不用再开一个数组维度
    //第一行初始为全部1，后续不断被下一行覆盖
    public int uniquePaths(int m, int n) {
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        int cur=0;//用来传答案

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){//直接从第二行第二列开始算
                cur=j;
                dp[cur]=dp[j]+dp[j-1];//=上一行对应列的路径数+同一行右边的路径数
            }
        }

        return dp[cur];


    }
}
