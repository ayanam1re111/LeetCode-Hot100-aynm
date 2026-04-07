package com.ayanami.leetcode.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class _003_LongestSubstringWithoutRepeatingCharacters {

        public static int lengthOfLongestSubstring(String s){
            // 底层是哈希表，基于哈希值直接定位，contains()时间复杂度为O（1），用于记录每个字符是否出现过
            Set<Character> occ=new HashSet<>();
            int rk=0;
            int leng=0;
            for(int i=0;i<s.length();i++){
                if(i!=0){
                    // 当右指针遇到重复字符进入新一轮遍历，左指针向右移动一格，移除一个字符
                    occ.remove(s.charAt(i-1));
                }
                while(rk<s.length() && !occ.contains(s.charAt(rk))){
                    occ.add(s.charAt(rk));
                    leng=Math.max(leng,rk-i+1);
                    rk++;
                }
            }
            return leng;}
}
