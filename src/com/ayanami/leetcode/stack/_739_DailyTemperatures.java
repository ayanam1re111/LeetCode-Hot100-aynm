package com.ayanami.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

//单调栈
public class _739_DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> ar=new ArrayDeque<>();
        int n=temperatures.length;
        int[] ans=new int[n];
        //倒着遍历
        for(int i=n-1;i>=0;i--){
            int s=temperatures[i];
            while(!ar.isEmpty()&&s>=temperatures[ar.peek()]){
                //如果当前数比右边数a大，那么再往左的数一定不需要和a比较，直接pop掉a
                ar.pop();
            }
            //出while循环说明右边多余的数已经清理干净，如果此时栈里还有数，那么用最顶上那个的索引减去i
            if(!ar.isEmpty()){
                ans[i]=ar.peek()-i;

            }
            //将当前索引推入栈
            ar.push(i);
        }
        return ans;


    }
}
