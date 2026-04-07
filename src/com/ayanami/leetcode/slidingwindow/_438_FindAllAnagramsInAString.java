package com.ayanami.leetcode.slidingwindow;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class _438_FindAllAnagramsInAString {
// class Solution {
//     public List<Integer> findAnagrams(String s, String p) {
//         int n=p.length();
//         char[] sample=p.toCharArray();
//         Arrays.sort(sample);
//         ArrayList<Integer> idx=new ArrayList<>();
//     //注意这里i的取值最大范围
//         for(int i=0;i<=s.length()-n;i++){
//             String a=s.substring(i,i+n);
//             char[] charArray=a.toCharArray();
//             Arrays.sort(charArray);
//             if(Arrays.equals(sample,charArray)){
//                 idx.add(i);

//             }
//         }
//         return idx;


    //     }
// }

        public List<Integer> findAnagrams(String s, String p) {
            // 统计 p 的每种字母的出现次数
            int[] cntp=new int[26];
            for(char c:p.toCharArray()){
                cntp[c-'a']++;//通过字母相减得出该字母出现次数在cntp数组中的索引，通过索引得到int进行++
            }
            List<Integer> ans =new ArrayList<>();
            int[] cnts=new int[26];
            for(int right =0;right<s.length();right++){
                cnts[s.charAt(right)-'a']++;
                int left =right-p.length()+1;
                if(left<0){
                    continue;//跳出整个循环
                }
                if(Arrays.equals(cntp,cnts)){
                    ans.add(left);
                }
                cnts[s.charAt(left)-'a']--;
            }
            return ans;

        }
    }

