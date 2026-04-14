package com.ayanami.leetcode.matrix;

public class _048_RotateImage {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        //水平翻转
        for(int i=0;i<n/2;i++){
            for(int j=0;j<n;j++){
                int temp=matrix[n-1-i][j];//临时变量储存即将被赋值的数
                matrix[n-i-1][j]=matrix[i][j];
                matrix[i][j]=temp;
            }}
        //主对角线翻转
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){//注意这里j的边界，只需要翻转对角线以下的元素即可，不然会翻转两次导致回到没翻转时状态
                int temp=matrix[j][i];
                matrix[j][i]=matrix[i][j];
                matrix[i][j]=temp;
            }}



    }
}
