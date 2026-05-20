package com.ayanami.leetcode.binarytree;

import java.util.HashMap;
import java.util.Map;

public class _437_PathSumIII {
    private int ans=0;

    private Map<Long,Integer> map=new HashMap<>();
    public int pathSum(TreeNode root, int targetSum) {
        map.put(0L,1);//为了使得当节点val=targetSum时候也能在map中查询到
        findchain(root,targetSum,0);
        return ans;
    }
    public void findchain(TreeNode node,int targetSum,long sum){
        if(node==null){
            return;
        }
        sum+=node.val;

        //查询是否存在和为targetSum的链
        ans+=map.getOrDefault(sum-targetSum,0);

        //将从根节点到当前节点的和放进map，并加上出现次数
        //这里必须在map.getOrDefault后面，不然会在测试用例root[1],tS=0时候出错
        map.merge(sum,1,Integer::sum);

        //继续走
        findchain(node.left,targetSum,sum);

        findchain(node.right,targetSum,sum);
        //走完一条，回溯
        map.merge(sum,-1,Integer::sum);



    }
}
