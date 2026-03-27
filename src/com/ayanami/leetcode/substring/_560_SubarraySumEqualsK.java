package com.ayanami.leetcode.substring;

import java.util.HashMap;
import java.util.Map;

public class _560_SubarraySumEqualsK {

        public int subarraySum(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();//键：pre(前i个数的累加和) 值：该值出现次数
            map.put(0, 1);//设定初始值：否则当pre-k=0，会没法进入if
            int count = 0;
            int pre = 0;

            for (int i = 0; i < nums.length; i++) {
                pre = pre + nums[i];
                if (map.containsKey(pre - k)) {//若pre-一直累加到nums[j]的和=k,那么说明nums[j+1]到nums[i]的和为k
                    int s = map.get(pre - k);//获得次数（因为数组可能包含0，导致多个连续位置的累加和相等，eg:100001）
                    count += s;
                }
                map.put(pre, map.getOrDefault(pre, 0) + 1);//若map中不存在pre，那么加入默认值（pre,0）然后再加次数为1，若存在则直接get得到当前次数再加一
            }
            return count;
        }

}
