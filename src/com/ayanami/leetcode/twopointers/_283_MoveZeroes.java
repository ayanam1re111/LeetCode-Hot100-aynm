package com.ayanami.leetcode.twopointers;

public class _283_MoveZeroes {

        // 总体思路：用快慢指针交换元素——快指针i找非0元素，慢指针j标记非0元素应放置的位置
        // 找到非0元素时，交换nums[i]和nums[j]，最终0会被“挤”到数组末尾
        public void moveZeroes(int[] nums) {
            int temp = 0; // 临时变量，用于交换两个位置的元素
            int j = 0;    // 慢指针j：标记「下一个非0元素要放置的位置」，初始为0

            // 快指针i：遍历整个数组，寻找非0元素
            for(int i = 0; i < nums.length; i++){
                // 找到非0元素，执行交换操作
                if(nums[i] != 0){
                    temp = nums[i];       // 先把非0元素暂存到temp

                    // 核心逻辑说明：
                    // 1. 若j==i：说明遍历到目前为止没有遇到0，nums[j]和nums[i]是同一个位置,值相等
                    // 2. 若j<i：说明j位置一定是0（j和i走的距离之差就是因为遍历到0时j没有前进，j停留的位置就是未被移动的0）
                    // 因此这一步赋值后，i位置会被替换为0，无需后续单独遍历置0
                    nums[i] = nums[j];
                    nums[j++] = temp;     // 把非0元素放到j位置，j后移（j最终值=非0元素的个数）
                }
            }
        }

}
