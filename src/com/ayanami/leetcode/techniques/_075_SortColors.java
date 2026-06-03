package com.ayanami.leetcode.techniques;

public class _075_SortColors {
    public void sortColors(int[] nums) {
        int n = nums.length;
        //单指针，指向下一个0/1应该被换到的位置
        int a = 0;

        //第一个循环，把0全部放到开头
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                int temp = nums[a];
                nums[a] = 0;
                nums[i] = temp;
                a++;
            }
        }
        //第二次循环，排1
        for (int j = a; j < n; j++) {
            if (nums[j] == 1) {
                int temp = nums[a];
                nums[a] = 1;
                nums[j] = temp;
                a++;
            }
        }
    }}
