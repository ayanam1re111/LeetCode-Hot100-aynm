package com.ayanami.leetcode.graphtheory;

import java.util.LinkedList;
import java.util.Queue;

public class _994_RottingOranges {//本题选用BFS
    /**
     DFS:腐烂的A → 直奔第一个发现新鲜的B → 深挖 B 的 D、E，直到无路可走
     退回 A，再去处理 C，再深挖 C 周边
     单条路径走到底，折返再走其他分支 */
    /**
     BFS:先处理 A，发现周围新鲜的即将被感染腐烂的B,先存入队列，继续找其他即将腐烂的
     再批量处理同层的 B、C
     最后统一处理 B、C 延伸出的下一层节点
     同层级全部走完，再推进下一层
     */
    public int orangesRotting(int[][] grid) {
        int m=grid.length;//行数
        int n=grid[0].length;
        Queue<int[]> queue=new LinkedList<>();
        int count=0;//计数新鲜橘子，最后看是否归零
        //先遍历存第一批腐烂橘子的坐标并且计数新鲜橘子
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    queue.offer(new int[]{i,j});
                }
                if(grid[i][j]==1){
                    count++;
                }

            }
        }
        //开始广度优先搜索，一层一层解决
        int depth=0;
        while(!queue.isEmpty()&&count>0){//这样最后新鲜橘子没有了，只剩队列里腐烂橘子时不会再进循环多加一次时间，而且遇到[[0]]的情况直接不进循环最后返回depth=0
            int c=queue.size();//本轮要处理的腐烂橘子数
            depth++;//加一分钟
            for(int i=0;i<c;i++){
                int[] ar=queue.poll();
                int a=ar[0];
                int b=ar[1];
                if(a+1<m&&grid[a+1][b]==1){
                    grid[a+1][b]=2;
                    queue.offer(new int[]{a+1,b});
                    count--;
                }
                if(b+1<n&&grid[a][b+1]==1){
                    grid[a][b+1]=2;
                    queue.offer(new int[]{a,b+1});
                    count--;
                }
                if(a-1>=0&&grid[a-1][b]==1){
                    grid[a-1][b]=2;
                    queue.offer(new int[]{a-1,b});
                    count--;
                }
                if(b-1>=0&&grid[a][b-1]==1){
                    grid[a][b-1]=2;
                    queue.offer(new int[]{a,b-1});
                    count--;
                }
            }
        }
        if(count>0){
            return -1;
        }else{
            return depth;
        }

    }
}
