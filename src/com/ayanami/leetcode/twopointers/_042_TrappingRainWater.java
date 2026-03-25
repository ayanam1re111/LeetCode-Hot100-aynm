package com.ayanami.leetcode.twopointers;

public class _042_TrappingRainWater {
    public int trap(int[] height) {
        //思路：只要height[i]左右两边分别最高的柱子中较低的一根高于height[i]，就可以储水
        int sum = 0;
        int[] max_left = new int[height.length];//长度为height.length的空数组[0,0,...]
        int[] max_right = new int[height.length];
        //首位肯定不会储水且为了防止数组越界，直接从1或height.length-2开始
        for (int i = 1; i < height.length - 1; i++) {//遍历，给max_left数组赋值
            max_left[i] = Math.max(max_left[i - 1], height[i - 1]);
        }//max_left[i]为在索引i时，左边高度最高的柱子高度
        for (int i = height.length - 2; i >= 0; i--) {
            max_right[i] = Math.max(max_right[i + 1], height[i + 1]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            int lower = Math.min(max_left[i], max_right[i]);//找到i时左右两边最高柱子中较小的一个
            if (lower > height[i]) {
                sum = sum + (lower - height[i]);
            }
        }
        return sum;
    }
}
