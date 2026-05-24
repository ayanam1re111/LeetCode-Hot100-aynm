package com.ayanami.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class _078_Subsets {
    public List<List<Integer>> subsets(int[] nums) {

        //记录本轮使用的元素
        List<Integer> path=new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
        dfs(0,nums,path,ans);
        return ans;
    }

    private void dfs(int i,int[] nums,List<Integer> path,List<List<Integer>> ans){
        int n=nums.length;
        if(n==0){
            return;
        }
        //终止条件
        if(i==n){
            ans.add(new ArrayList<Integer>(path));
            return;
        }

        //子集不要当前元素的情况，直接进入下一轮
        dfs(i+1,nums,path,ans);
        //子集需要当前元素
        path.add(nums[i]);
        dfs(i+1,nums,path,ans);
        path.removeLast();//每执行完一轮要清除本轮加入的元素
        return;



    }
}
