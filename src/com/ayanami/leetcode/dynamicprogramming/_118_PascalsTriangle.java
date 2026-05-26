package com.ayanami.leetcode.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class _118_PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> ans =new ArrayList<>(numRows);
        ans.add(List.of(1));

        for(int i=1;i<numRows;i++){
            List<Integer> list=new ArrayList<>(i+1);
            list.add(1);//首尾都是1
            for(int j=1;j<i;j++){
                list.add(ans.get(i-1).get(j-1)+ans.get(i-1).get(j));
            }
            list.add(1);
            ans.add(list);
        }
        return ans;

    }
}
