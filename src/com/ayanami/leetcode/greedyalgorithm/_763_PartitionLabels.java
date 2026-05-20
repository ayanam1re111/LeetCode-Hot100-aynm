package com.ayanami.leetcode.greedyalgorithm;

import java.util.ArrayList;
import java.util.List;

public class _763_PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        int length = s.length();
        //将字母的索引按照字母顺序放进对应位置，最后每个字母位置上的数字就是该字母最后索引
        for (int i = 0; i < length; i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        List<Integer> ans = new ArrayList<Integer>();
        int start = 0, end = 0;
        for (int i = 0; i < length; i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']);
            //如果当前索引等于end，说明当前字母及以前字母全部被包含在end及end之前
            if (i == end) {
                ans.add(end - start + 1);
                //更新起点
                start = end + 1;
            }
        }
        return ans;
    }


}
