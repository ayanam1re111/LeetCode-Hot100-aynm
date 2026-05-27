package com.ayanami.leetcode.dynamicprogramming;

import java.util.Arrays;

public class _322_CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] g=new int[amount+1];
        Arrays.fill(g,Integer.MAX_VALUE/2);
        //初始赋值
        g[0]=0;
        //两层循环：每次加入新的硬币，然后判断每一个amount下使用这枚硬币和不使用哪个使用硬币个数最小,并更新
        for(int c:coins){
            for(int i=c;i<=amount;i++){
                g[i]=Math.min(g[i],g[i-c]+1);
            }
        }

        return g[amount]<Integer.MAX_VALUE/2 ? g[amount]:-1;
    }

}
