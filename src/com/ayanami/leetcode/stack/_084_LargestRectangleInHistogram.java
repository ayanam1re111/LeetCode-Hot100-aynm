package com.ayanami.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class _084_LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int len=heights.length;
        if(len==0){
            return 0;
        }
        if(len==1){
            return heights[0];
        }
        int ans=0;
        Deque<Integer> stack=new ArrayDeque<>(len);
        for(int i=0;i<len;i++){
            //如果当前柱体高度小于前面的柱子a高度，那么取出柱子a的高度
            while(!stack.isEmpty()&&heights[i]<heights[stack.peek()]){
                int temph=heights[stack.poll()];
                //去掉重复高度的柱子
                while(!stack.isEmpty()&&heights[stack.peek()]==temph){
                    stack.poll();
                }
                int tempw;
                //如果此时栈为空，也就是左边没有比他矮的，那么宽度直接到最左边
                if(stack.isEmpty()){
                    tempw=i;
                    //如果不为空，此时的栈顶就是离他最近且比他矮的
                }else{
                    tempw=i-stack.peek()-1;
                }
                //更新最大面积
                ans=Math.max(ans,temph*tempw);
            }
            stack.push(i);

        }
        //处理最后剩下的最矮的没被清除的柱子
        while(!stack.isEmpty()){
            int temph=heights[stack.pop()];
            while(!stack.isEmpty()&&heights[stack.peekLast()]==temph){
                stack.poll();
            }
            int tempw;
            //如果没有剩余，说明此时是最矮的，宽度可以贯穿全长
            if(stack.isEmpty()){
                tempw=len;
                //走这个逻辑说明剩下的柱子是递增
            }else{
                tempw=len-stack.peek()-1;
            }
            ans=Math.max(ans,tempw*temph);
        }
        return ans;

    }
}
