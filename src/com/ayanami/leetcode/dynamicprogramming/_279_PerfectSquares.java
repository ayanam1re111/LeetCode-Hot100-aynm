package com.ayanami.leetcode.dynamicprogramming;

import java.util.Arrays;

public class _279_PerfectSquares {
    //因为n最大为10000
    private static final int[][] memo=new int[101][10001];
    //初始化
    static{
        for(int[] row:memo){
            Arrays.fill(row,-1);//表示没有计算过
        }

    }
    public int numSquares(int n) {
        return dfs((int)Math.sqrt(n),n);
    }

    private int dfs(int i,int j){
        //终止条件，i=0时候没法选，
        if(i==0){
            if(j==0){//到底了，返回0到上一层·
                return 0;
            }else if(j!=0){//说明该路径不行，返回大值保证不会被Math.min选到
                return Integer.MAX_VALUE;

            }
        }
        //如果此时i的平方大于j,直接递归i-1
        if(i*i>j){
            return memo[i][j]=dfs(i-1,j);//必须要return出去，不能单纯调用，不然当前轮次的i,j还会执行后面代码，出现索引越界
        }
        //记忆化搜索
        if(memo[i][j]!=-1){
            return memo[i][j];
        }

        return memo[i][j]=Math.min(dfs(i,j-i*i)+1,dfs(i-1,j));//选或不选
    };
}
