package com.ayanami.leetcode.multidimensionalDP;

public class _1143_LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] t1=text1.toCharArray();
        char[] t2=text2.toCharArray();
        int m=t1.length;
        int n=t2.length;
        int[][] f=new int[m+1][n+1];
        //f[0][0]对应递归的终止条件，用来作为第一个f[1][1]算出来的基石,所以说要从f[i+1][j+1]开始
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                f[i+1][j+1]= t1[i]==t2[j] ? f[i][j]+1 : Math.max(f[i][j+1],f[i+1][j]);
            }
        }

        return f[m][n];
    }
}
