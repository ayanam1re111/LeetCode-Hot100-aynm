package com.ayanami.leetcode.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
//Collectors 是一个工具类，里面全是静态方法
//Collectors.groupingBy() 是 Java 提供的现成 Collector，专门实现 “按 Key 分组” 的逻辑，最终返回 Map<Key, List<元素>>
//groupingBy 底层会自动处理 “重复 Key”：遇到新 Key → 创建一个空的 List，把当前元素加进去，
// 作为该 Key 的 Value；遇到已存在的 Key → 直接把当前元素添加到该 Key 对应的 List 中；
public class _049_GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        //把数组转为流,准备遍历
        return new ArrayList<>(Arrays.stream(strs)
                .collect(Collectors.groupingBy(str->{//lamda表达式（遍历中对str执行如下操作）
                    char[] a=str.toCharArray();//将str转为字符数组 a=['e','a','t']
                    Arrays.sort(a);//对字符数组进行排序 a=['a','e','t']
                    return new String(a);//将字符数组转回字符串，作为key返回 'aet'
                })).values());//提取map中的所有值,这里的value是ArrayList类型，所以说一个键可以有多个值


    }
}
