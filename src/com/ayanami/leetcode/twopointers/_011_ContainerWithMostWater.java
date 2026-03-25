package com.ayanami.leetcode.twopointers;

public class _011_ContainerWithMostWater {
    public int maxArea(int[] height){
        int i=0;
        int j=height.length-1;
        int area=0;
        while(i<j){

            area=height[i]<height[j] ?
                    Math.max(area,(j-i)*height[i++])://先计算面积，再自增1进入下一个循环
                    Math.max(area,(j-i)*height[j--]);
            //    if (height[i]<height[j]){
            //             area=Math.max(area,(j-i)*height[i]);
            //             i++;
            //         }else if(height[i]>=height[j]){
            //             area=Math.max(area,(j-i)*height[j]);
            //             j--;
            //         }

        }
        return area;

    }

}
