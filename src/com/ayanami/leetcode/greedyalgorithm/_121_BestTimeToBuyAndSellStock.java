package com.ayanami.leetcode.greedyalgorithm;

public class _121_BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int profit=0;
        int cost=prices[0];
        for(int i=1;i<prices.length;i++){
            int p=prices[i];
            cost=Math.min(cost,p);
            profit=Math.max(profit,p-cost);
        }
        return profit;

    }
}
