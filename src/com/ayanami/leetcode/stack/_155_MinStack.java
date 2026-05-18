package com.ayanami.leetcode.stack;

import java.util.Stack;

public class _155_MinStack {
    //中心思想，数组栈，每次压入[当前值，当前最小值]
    private Stack<int[]> stack=new Stack<>();
    public _155_MinStack() {

    }

    public void push(int val) {
        //如果栈为空，存入[x,x]
        if (stack.isEmpty()){
            stack.push(new int[]{val,val});
        }else{
            stack.push(new int[]{val,Math.min(val,stack.peek()[1])});
        }


    }

    public void pop() {
        if(!stack.isEmpty()){
            stack.pop();}

    }

    public int top() {
        if(!stack.isEmpty()){
            return stack.peek()[0];}

        else{return 0;}}

    public int getMin() {
        if(!stack.isEmpty()){
            return stack.peek()[1];  }
        return 0;
    }
}
