package com.ayanami.leetcode.dynamicprogramming;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _139_WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        int maxLength=0;
        for(String word: wordDict){
            maxLength=Math.max(maxLength,word.length());        }
        int n=s.length();
        boolean[] g=new boolean[n+1];
        g[0]=true;

        Set<String> words=new HashSet<>(wordDict);

        for(int i=1;i<=n;i++){
            for (int j=i-1;j>=Math.max(i-maxLength,0);j--){
                if(g[j] && words.contains(s.substring(j,i))){
                    g[i]=true;
                    break;
                }
            }
        }

        return g[n];

    }
}
