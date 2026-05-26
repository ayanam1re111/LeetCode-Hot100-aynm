package com.ayanami.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class _131_PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> ans=new ArrayList<>();
        List<String> path=new ArrayList<>();
        int n=s.length();

        dfs(0,0,ans,path,s,n);
        return ans;
    }

    private void dfs(int i,int start,List<List<String>> ans,List<String> path,String s,int n){
        //终止条件
        if(i==n){
            ans.add(new ArrayList<>(path));
            return;
        }

        //不选择当前处切断
        if(i<n-1){//i到最后一个时候必须切断
            dfs(i+1,start,ans,path,s,n);
        }

        //选择切断
        if(isPalindrome(start,i,s)){
            path.add(s.substring(start,i+1));
            //此时剩下[i+1，n-1]
            dfs(i+1,i+1,ans,path,s,n);
            path.removeLast();
        }
    }
    //判断切割子串是否为回文
    private boolean isPalindrome(int left,int right,String s){
        while(left<right){
            if(s.charAt(left++)!=s.charAt(right--)){
                return false;
            }
        }
        return true;
    }
}
