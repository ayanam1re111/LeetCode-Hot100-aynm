package com.ayanami.leetcode.techniques;

public class _287_FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int slow=0;
        int fast=0;
        //先找到快慢指针相遇点
        slow=nums[slow];//慢指针走一步
        fast=nums[nums[fast]];//快指针走两步
        while(slow!=fast){
            slow=nums[slow];//慢指针走一步
            fast=nums[nums[fast]];//快指针走两步
        }
        //指针l从开头走到环入口，指针r从相遇点走到环入口，两段经过推导距离一定相等
        int l=0;
        int r=slow;
        while(l!=r){
            l=nums[l];
            r=nums[r];
        }
        return r;
    }
}
