package com.ayanami.leetcode.substring;

public class _076_MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int n=s.length();
        char[] S=s.toCharArray();
        //记录目前窗口里的字符和目标字符相差多少
        int[] diff=new int[128];
        //记录t中有多少种不同字母
        int kind=0;
        int count=0;
        int ansR=n;
        int ansL=-1;
        int left=0;


        for(char c:t.toCharArray()){
            if(diff[c]==0){
                kind++;
            }
            diff[c]--;
        }

        for(int right=0;right<n;right++){
            char a=S[right];
            diff[a]++;
            //只有t中存在的字母才有可能在这里出现diff[a]==0
            if(diff[a]==0){
                count++;
            }

            while(count==kind){
                if(right-left<ansR-ansL){
                    ansR=right;
                    ansL=left;
                }
                char b=S[left];
                if(diff[b]==0){
                    count--;
                }
                diff[b]--;
                left++;

            }



        }

        return ansL<0 ? "" : s.substring(ansL,ansR+1);



    }
}
