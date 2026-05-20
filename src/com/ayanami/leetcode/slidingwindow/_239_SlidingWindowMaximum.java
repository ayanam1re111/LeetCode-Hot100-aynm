package com.ayanami.leetcode.slidingwindow;

import java.util.ArrayDeque;
import java.util.Deque;

public class _239_SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        //窗口的个数
        int[] ans=new int[n-k+1];
        //用双向队列解决，因为又要再头部加新元素，又要取尾部的最大值索引
        Deque<Integer> q=new ArrayDeque<>();

        for(int i=0;i<n;i++){
            //如果nums[i]大于等于之前队列里的元素，那么之前的元素在后续不可能成为窗口最大值，因为每一轮都是nums[i]作为右端点，所以删掉他们
            while(!q.isEmpty() && nums[i]>=nums[q.getLast()]){//getLast取队尾（最新加进来的元素）;*peek.poll永远操作头部，push压栈到头部，offer放元素到尾部*
                q.removeLast();
            }
            //将新元素索引加入队尾
            q.offer(i);
            //判断此时队首是否已经离开窗口
            int left=i-k+1;//窗口左端点
            if(left>q.getFirst()){
                q.removeFirst();
            }
            //左端点一旦开始>0,窗口形成，开始取队首元素计入答案(队列一定是递减的，因为在循环第一步就删掉了所有队列中比nums[i]小的)
            if(left>=0){
                ans[left]=nums[q.getFirst()];
            }




        }
        return ans;
    }
}
