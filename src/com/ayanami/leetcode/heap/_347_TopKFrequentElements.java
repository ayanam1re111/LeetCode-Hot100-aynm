package com.ayanami.leetcode.heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class _347_TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        //增强for循环遍历将元素以及其出现次数存入map
        Map<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        //构造小顶堆（堆顶最小）
        PriorityQueue<int[]> queue=new PriorityQueue<int[]>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[1]-b[1];//重写comparator接口的抽象方法(规则：返回为负数，就a在前),按照次数升序
            }
        });
        //遍历map
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            //如果堆里已经有k组，与目前里面最小的比较大小，去掉小的
            int m=entry.getKey();
            int n=entry.getValue();
            if(queue.size()==k){
                if(n>queue.peek()[1]){
                    queue.poll();
                    queue.offer(new int[]{m,n});
                }
            }else{
                //如果堆里还不满k个，直接offer
                queue.offer(new int[]{m,n});}

        }
        //将堆里的数组输出key
        int[] ans=new int[k];
        for(int i=0;i<k;i++){
            ans[i]=queue.poll()[0];
        }
        return ans;


    }
}
