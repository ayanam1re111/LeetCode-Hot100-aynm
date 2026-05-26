package com.ayanami.leetcode.backtracking;

public class _079_WordSearch {
    public static final int[][] DIRECT={{0,1},{0,-1},{1,0},{-1,0}};
    public boolean exist(char[][] board, String word) {
        //将矩阵中的每个字母出现次数记录下来
        int[] ch=new int[128];
        for(char[] row:board){
            for(char c: row){
                ch[c]++;//c自动转为ASCII数字
            }
        }

        //优化1：如果board中某个字母数量不足word中的，直接返回false
        char[] wd= word.toCharArray();
        int len=wd.length;
        int[] count=new int[128];
        for(char w:wd){
            if(++count[w]>ch[w]){
                return false;
            }
        }

        //优化2：如果board中对应的word尾字母数量小于首字母，从尾字母开始寻找
        if(ch[wd[wd.length-1]]<ch[wd[0]]){
            wd=new StringBuilder(word).reverse().toString().toCharArray();
        }

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(dfs(i,j,0,board,wd,len)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i,int j,int dpt,char[][] board,char[] wd,int len){
        //当前字母匹配失败
        if(board[i][j]!=wd[dpt]){
            return false;
        }
        //匹配成功
        if(dpt==len-1){
            return true;
        }
        //标记已经访问过,防止回头路
        board[i][j]=0;
        //遍历前后左右找下一个
        for(int[] d:DIRECT){
            int x=i+d[0];
            int y=j+d[1];
            if(0<=x && x<board.length && 0<=y && y<board[x].length && dfs(x,y,dpt+1,board,wd,len)){
                return true;

            }
        }
        //如果[i][j]的四个方向都没找到匹配的，那么恢复现场，不然之后走别的路时候没法走ij
        board[i][j]=wd[dpt];
        return false;
    }
}
