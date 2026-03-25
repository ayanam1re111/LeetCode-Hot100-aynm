package com.ayanami.leetcode.hashmap;

import java.util.HashMap;
import java.util.Map;

class _001_TwoSum {
    //1.创建空HashMap
    // 2.遍历数组，在map里面找是否有补数，
    // 若未找到则将该轮遍历的数组中的数以{键：数，值：索引}的方式存入map;若找到则直接创建新数组输出索引；
    // 若遍历完仍未找到，抛出非法参数异常（即传入的nums 和target不合法）

    //HashMap:无序，不重复（键），无索引
    public int[] twoSum(int[] nums,int target){
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                int a=map.get(target-nums[i]);
                return new int[]{a,i};//注意这里写法
            }else{
                map.put(nums[i],i);
            }
        }
        throw new IllegalArgumentException("no result");//一定要抛出异常，不然编译器会认为如果循环结束了没有return，或者一次都没循环，就会报错
    }}
