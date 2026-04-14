package com.ayanami.leetcode.matrix;

import java.util.ArrayList;
import java.util.List;

public class _053_SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        List<Integer> ans=new ArrayList<>();
        int h=0;//上边界
        int e=0;//左边界
        int a=m-1;//下边界
        int b=n-1;//右边界

        while(true){
            //正遍历行
            for(int i=e;i<=b;i++) ans.add(matrix[h][i]);
            if(++h>a) break; //如果再向下移一次上边界，索引大于m-1，则说明已走完
            //正遍历列
            for(int i=h;i<=a;i++) ans.add(matrix[i][b]);
            if(--b<e) break;//如果再向左移一次右边界，索引小于新的左边界，则说明已走完
            //逆遍历行
            for(int i=b;i>=e;i--) ans.add(matrix[a][i]);
            if(--a<h) break;//如果再向上移一次下边界，索引小于新的上边界，则说明已走完
            //逆遍历列
            for(int i=a;i>=h;i--)ans.add(matrix[i][e]);
            if(++e>b) break;//如果再向右移一次左边界，索引大于b，则说明已走完
        }

        return ans;


    }
}
