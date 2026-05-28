package com.ayanami.leetcode.dynamicprogramming;

public class _032_LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int[] dp = new int[n];
        int max_len = 0;

        for (int i = 1; i < n; i++) {//i从1开始因为首先单个括号一定无效，另外防止i-1索引越界
            if (s.charAt(i) == ')') {
                //如果上一个是左括号
                if (s.charAt(i - 1) == '(') {
                    //如果i在开头
                    if (i < 2) {
                        dp[i] = 2;
                    } else {
                        dp[i] = dp[i - 2] + 2;
                        System.out.println(dp[i]);

                    } //如果上一个为右括号
                } else {
                    if (dp[i - 1] != 0) {
                        //求dp[i]左边界索引,判断是否存在正确左边界
                        int dpleft = i - dp[i - 1] - 1;
                        if (dpleft>=0&& s.charAt(dpleft) == '(') {//要先判断左边界在索引内！
                            dp[i] = dp[i - 1] + 2;

                            if (dpleft != 0 && dp[dpleft - 1] != 0) {//如果左边界之前还有成对括号，加上
                                dp[i] = dp[i] + dp[dpleft - 1];
                            }
                        }
                    }
                }
            }

            max_len = Math.max(max_len, dp[i]);
        }
        return max_len;
    }
}
