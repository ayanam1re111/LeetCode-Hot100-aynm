package com.ayanami.leetcode.hash;

import java.util.HashSet;
import java.util.Set;

public class _128_LongestConsecutiveSequence {
    // 定义主方法，输入是整数数组nums，返回最长连续序列的长度
    public int longestConsecutive(int[] nums) {
        // 1. 第一步：创建一个HashSet集合，用于存储数组中的所有数字
        Set<Integer> num_set = new HashSet<Integer>();
        // 2. 遍历输入数组，把每个数字都添加到HashSet中
        for (int num : nums) {
            num_set.add(num);
        }

        // 3. 初始化最长连续序列的长度为0（默认没有任何数字时长度为0）
        int longestStreak = 0;

        // 4. 遍历HashSet中的每一个数字（去重后的数字）
        for (int num : num_set) {
            // 5. 核心判断：只有当num-1不在集合中时，才以num为起点开始统计
            //    这一步是优化的关键！避免重复统计（比如1,2,3中，只从1开始统计，不会从2、3开始）
            if (!num_set.contains(num - 1)) {
                // 6. 初始化当前连续序列的起点为num
                int currentNum = num;
                // 7. 初始化当前连续序列的长度为1（至少包含自己）
                int currentStreak = 1;

                // 8. 循环查找currentNum+1是否在集合中（找连续的下一个数字）
                while (num_set.contains(currentNum + 1)) {
                    // 9. 找到下一个连续数字，更新当前数字
                    currentNum += 1;
                    // 10. 当前连续序列长度+1
                    currentStreak += 1;
                }

                // 11. 比较当前序列长度和最长序列长度，保留更大的值
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        // 12. 返回最终找到的最长连续序列长度
        return longestStreak;
    }
}
