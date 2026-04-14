package com.ayanami.leetcode.matrix;

public class _240_SearchA2dMatrix {
    public boolean searchMatrix(int[][] matrix, int target){
        int m=matrix.length;
        int n=matrix[0].length;
        int i=0;
        int j=n-1;
        //从右上角开始遍历判断大小
        while(i<m && j>=0){
            //若大于target，把[i][j]的列删掉（往左走）
            if(matrix[i][j]>target){
                j--;
                //若小于，把行删掉（往下走）
            }else if(matrix[i][j]<target){
                i++;
            }else{
                return true;
            }
        }

        return false;

    }
}
