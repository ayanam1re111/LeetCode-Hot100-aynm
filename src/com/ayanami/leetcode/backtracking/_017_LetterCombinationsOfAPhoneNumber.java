package com.ayanami.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class _017_LetterCombinationsOfAPhoneNumber {
    private static final String[] MAPPING=new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        int n=digits.length();
        if(n==0){
            return List.of();
        }

        List<String> ans=new ArrayList<>();
        char[] path=new char[n];
        dfs(0,ans,path,digits.toCharArray());
        return ans;

    }

    private void dfs(int i,List<String> ans,char[] path,char[] digits){
        if(i==digits.length){
            ans.add(new String(path));
            return;
        }
        String letters=MAPPING[digits[i]-'0'];//找到对应的那几个字母
        for(char c:letters.toCharArray()){
            path[i]=c;//遍历选中的字母,将他放在当前位，
            //然后调用递归函数，将后一个数字对应的字母遍历放到当前字母后一位，重复直至长度等于输入数字长度，加入答案
            dfs(i+1,ans,path,digits);
        }
    }
}
