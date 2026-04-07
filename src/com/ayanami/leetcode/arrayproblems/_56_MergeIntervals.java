package com.ayanami.leetcode.arrayproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _56_MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if(intervals.length==0){
            return new int[0][2];
        }

        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] itv1,int[] itv2){//这里的int[]指的是一维数组还是二维数组
                return itv1[0]-itv2[0];
            }});

        List<int[]> ans=new ArrayList<>();
        for(int i=0;i<intervals.length;i++){

            int s=intervals[i][0];
            int e=intervals[i][1];
            if(ans.size()==0 || s>ans.get(ans.size()-1)[1]){
                ans.add(intervals[i]);
            }else{
                ans.get(ans.size()-1)[1]=Math.max(e,ans.get(ans.size()-1)[1]);
            }




        }

        return ans.toArray(new int[ans.size()][]);

    }
}
