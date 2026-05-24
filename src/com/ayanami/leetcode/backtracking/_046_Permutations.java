package com.ayanami.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class _046_Permutations { public List<List<Integer>> permute(int[] nums) {
    int depth=0;
    boolean[] used=new boolean[nums.length];//用来记录当前索引处数字是否已经使用，默认为false
    List<Integer> path=new ArrayList<>();//记录当前轮次的小数组
    List<List<Integer>> ans=new ArrayList<>();
    dfs(nums,depth,used,path,ans);
    return ans;      }

    private void dfs(int[] nums,int depth,boolean[] used,List<Integer> path,List<List<Integer>> ans){
        //终止条件：如果数组长度等于nums.length,将该数组加入ans，返回
        int n=nums.length;
        if(depth==n){
            ans.add(new ArrayList<>(path));//这里必须复制一个path，直接传path由于path一直被改动，最后被删减为空数组，所以最终ans返回值全部为空
            return;
        }

        for(int i=0;i<n;i++){
            if(!used[i]){
                path.add(nums[i]);
                used[i]=true;//标记以使用元素
                dfs(nums,depth+1,used,path,ans);
                //恢复设置,回到上一步，然后在该位置重新尝试其他元素
                used[i]=false;
                path.removeLast();}




        }    }
}
