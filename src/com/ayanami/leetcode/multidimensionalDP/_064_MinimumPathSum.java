package com.ayanami.leetcode.multidimensionalDP;

public class _064_MinimumPathSum {//只需手动计算下一行第一列的数，那么当前dp[]数组就已经有了本行需要计算所有元素的左和上方前置值
    public int minPathSum(int[][] grid) {
        int n=grid[0].length;//计算一共几列
        int m=grid.length;
        int[] dp=new int[n];
        dp[0]=grid[0][0];
        //先计算第一行，填充数组
        for(int i=1;i<n;i++){
            dp[i]=dp[i-1]+grid[0][i];
        }

        for(int j=1;j<m;j++){
            dp[0]=dp[0]+grid[j][0];//计算下一行第一列
            for(int i=1;i<n;i++){
                dp[i]=Math.min((grid[j][i]+dp[i-1]),(grid[j][i]+dp[i]));
            }
        }
        return dp[n-1];

    }
}
