package com.ayanami.leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;

public class _394_DecodeString {
    public String decodeString(String s) {
        int mul=0;
        StringBuilder ans=new StringBuilder();

        //存乘数
        Deque<Integer> stack_mul=new LinkedList<>();
        //临时存放之前的字母串
        Deque<String> stack_res=new LinkedList<>();

        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='['){
                //将数字压入栈，防止嵌套数字的输入出错
                stack_mul.push(mul);
                //将之前完成的字符串加入临时栈,因为要应对嵌套用例(要转为字符串)
                stack_res.push(ans.toString());
                //清空ans,mul
                ans=new StringBuilder();
                mul=0;
            }else if(c==']'){
                //拿出最近的mul
                int m=stack_mul.pop();
                //拿出最近存的字符串
                String preString=stack_res.pop();
                //构建字符串，将之前的加上
                StringBuilder temp=new StringBuilder(preString);
                for(int j=0;j<m;j++){
                    temp.append(ans);}
                ans=temp;

            }else if(c>='0'&&c<='9'){
                mul=mul*10+(c-'0');//ASCII码相减
            }else{
                //字母直接接下去
                ans.append(c);
            }

        }
        return ans.toString();
    }

}
