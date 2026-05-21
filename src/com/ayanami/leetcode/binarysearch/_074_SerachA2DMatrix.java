package com.ayanami.leetcode.binarysearch;

public class _074_SerachA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        //矩阵行数
        int m=matrix.length;
        //矩阵列数
        int n=matrix[0].length;

        int left=-1;
        int right=m*n;

        while(left+1!=right){
            int mid=(right-left)/2+left;
            int num=matrix[mid/n][mid%n];
            if(num==target){
                return true;
            }
            if(num>=target){
                right=mid;
            }else{
                left=mid;
            }
        }
        return false;

    }
}
