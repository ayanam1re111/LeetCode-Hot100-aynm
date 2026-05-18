package com.ayanami.leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;

public class _020_ValidParentheses {
    public boolean isValid(String s) {
        Deque<Character> dq=new LinkedList<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            //若ch为左括号，将右括号压入栈，用于待会对比
            if(ch=='('){
                dq.push(')');
            }else if(ch=='{'){
                dq.push('}');
            }else if(ch=='['){
                dq.push(']');
                //如果第一个字符就是右括号或者右括号与此时栈顶字符不相等，直接返回false
                //要先判断栈空，不然peek(),pop()会报错
            }else if(dq.isEmpty()||dq.peek()!=ch){
                return false;
            }else{
                dq.pop();//当前右括号与dq最上面的相同，删除最上面的
            }
        }
        return dq.isEmpty();//如果不为空说明左右括号数量不对称

    }
}
