package com.ayanami.leetcode.multidimensionalDP;

public class _005_LongestPalindromicSubstring {
    public String longestPalindrome(String S) {
        char[] s=S.toCharArray();
        int n=s.length;
        int al=0;
        int ar=0;

        //一共有2*n-1个可能的回文中心
        for(int i=0;i<2*n-1;i++){
            int l=i/2;
            int r=(i+1)/2;
            //如果l和r相等，就继续向两边扩散直到回文消失
            while(l>=0 && r<n && s[l]==s[r]){
                l--;
                r++;
            }
            //比较,注意这里l和r出来循环时候多做了一次加减，所以此时回文区间为开区间（l,r）
            if(r-l-1>ar-al){
                al=l+1;
                ar=r;
            }
        }
        return S.substring(al,ar);



    }
}
