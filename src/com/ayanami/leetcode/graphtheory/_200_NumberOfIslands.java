package com.ayanami.leetcode.graphtheory;

public class _200_NumberOfIslands {
    public int numIslands(char[][] grid) {
        int count=0;
        int h=grid.length;
        int l=grid[0].length;
        for(int i=0;i<h;i++){
            for(int j=0;j<l;j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);//调用,当dfs返回，说明此时已经走遍该岛屿的边界
                    count++;

                }}
        }
        return count;

    }
    private void dfs(char[][] grid,int i,int j){
        int h=grid.length;
        int l=grid[0].length;
        //如果走出grid边界或者走到水上，则不能继续递归，直接返回
        if(i<0 || j<0||i>=h|| j>=l||grid[i][j]!='1'){
            return;}
        //给走过的格子染色,因为之后新的岛屿肯定不需要再走这个格子
        grid[i][j]='2';
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);



    }
}
