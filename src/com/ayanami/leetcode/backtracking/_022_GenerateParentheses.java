package com.ayanami.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class _022_GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        char[] path=new char[n*2];
        dfs(n,ans,path,0,0);
        return ans;
    }

    private void dfs(int n,List<String> ans, char[] path,int left,int right){
        //终止条件：如果右边=n说明全部完成
        if(right==n){
            ans.add(new String(path));
            return;
        }

        //选择左边
        if(left<n){
            path[left+right]='(';
            dfs(n,ans,path,left+1,right);}

        //选择右边
        if(right<left){//第一个必须左括号
            path[left+right]=')';//这里直接覆盖之前选择在该位置加的左括号，所以path不用还原
            dfs(n,ans,path,left,right+1);}

    }
}
