package com.ayanami.leetcode.heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class _295_FindMedianFromDataStream {//构造两个堆，A为小顶堆，存放较大的元素，B为大顶堆，存放较小的元素
    Queue<Integer> A,B;//必须构造为成员变量，不然别的方法拿不到
    public _295_FindMedianFromDataStream() {
        A=new PriorityQueue<>();
        B=new PriorityQueue<>((x, y)->(y-x));

    }
    public void addNum(int num) {
        //主体操作：先给A堆加元素，再给B，轮流加。
        //但是为了保持顺序以取用两堆顶计算中位数，在需要给A加的轮次先将元素加到B，利用大顶堆自动排序poll出最大元素加给A，B轮次同理
        if(A.size()==B.size()){
            B.add(num);
            A.add(B.poll());
        }else{
            A.add(num);
            B.add(A.poll());
        }
    }

    public double findMedian() {
        if(A.size()!=B.size()){//因为A先加元素，所以如果AB元素量不相等，一定是A比B多一个
            return A.peek();
        }else{
            return (A.peek()+B.peek())/2.0;
        }

    }
}
