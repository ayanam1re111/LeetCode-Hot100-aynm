package com.ayanami.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _051_NQueens {
    public List<List<String>> solveNQueens(int n) {
        //记录每一行第几列放queen
        int[] isqueen=new int[n];

        //用于判断目前该位置是否可以存皇后
        boolean[] col=new boolean[n];//记录该列是否已经存皇后
        boolean[] mdiag=new boolean[n*2-1];//记录主对角线坐标和
        boolean[] adiag=new boolean[n*2-1];//记录副对角线坐标和

        List<List<String>> ans=new ArrayList<>(n);

        dfs(n,0,isqueen,col,mdiag,adiag,ans);
        return ans;


    }

    private void dfs(int n,int r,int[] isqueen,boolean[] col,boolean[] mdiag,boolean[] adiag,List<List<String>> ans){
        //终止条件,行数=n
        if(r==n){
            List<String> ta=new ArrayList<>(n);//根据要求返回值，这里设置动态数组比普通数组代码更简洁
            for(int c:isqueen){
                char[] temp=new char[n];
                Arrays.fill(temp,'.');
                temp[c]='Q';
                ta.add(new String(temp));
            }
            ans.add(ta);
            return;
        }

        for(int c=0;c<n;c++){
            //防止出现负数，所以集体加上n-1，使得定义域为[0,n-1]
            int diag=r-c+n-1;
            if(!col[c]&&!mdiag[r+c]&&!adiag[diag]){
                //若皆不存在，则占位
                isqueen[r]=c;
                col[c]=true;
                mdiag[r+c]=true;
                adiag[diag]=true;
                //继续下一行
                dfs(n,r+1,isqueen,col,mdiag,adiag,ans);
                col[c]=mdiag[r+c]=adiag[diag]=false;//恢复现场，从r=n那一层跳出，回到上一层继续循环遍历尝试新的位置
            }
        }

    }
}
