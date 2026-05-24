package com.ayanami.leetcode.graphtheory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _207_CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //创建数组存每个课需要几个先修课（入度）
        int[] degree=new int[numCourses];
        //创建动态数组列表[a课程，学完a课程可以学的其他课程],目的是为了后续可以根据出栈的已学课程快速找到入度可以减一的后续课
        List<List<Integer>> list=new ArrayList<>();
        //遍历先给每个课程创建好空动态数组
        for(int i=0;i<numCourses;i++){
            list.add(new ArrayList<>());
        }

        //构建list，并计算每门课的入度
        for(int[] prer:prerequisites){
            int precourse=prer[1];
            int nextcourse=prer[0];
            degree[nextcourse]++;
            list.get(precourse).add(nextcourse);//将后续课的课程号加在先修课的索引位置
        }

        //储存入度为0的课程列表
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(degree[i]==0){
                queue.offer(i);
            }
        }
        //记录已经完成的课程数量
        int count=0;
        while(!queue.isEmpty()){
            int finishcourse=queue.poll();
            count++;
            //根据已完成的课程号从list中get出他的后续课程
            List<Integer> futurecourses=new ArrayList<>();
            futurecourses=list.get(finishcourse);
            //将每个后续课程的入度减一
            for(int fc:futurecourses){
                degree[fc]--;
                //如果此时入度为0,加入队列开始学习
                if(degree[fc]==0){
                    queue.offer(fc);
                }
            }


        }
        return count==numCourses;
    }
}
