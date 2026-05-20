package com.ayanami.leetcode.greedyalgorithm;

public class _045_JumpGameII {
    //中心思想：用最远距离当断点，一个一个跳，更新最远距离，以最远距离作为下一组的end,到达end次数+1(因为end一定在最后索引前，所以这一组的一次跳跃是必须要的)
    public int jump(int[] nums) {
        int len=nums.length;
        int end=0;
        int des=0;
        int ans=0;
        //i不能直接遍历到最后一个，不然会多一次跳跃
        for(int i=0;i<nums.length-1;i++){
            int n=nums[i];
            des=Math.max(des,i+n);

            //不需要设置截停，因为如果某一次des达到最后索引或者超过索引，那么之后的i永远不会到达end，不会增加次数
            if(i==end){
                end=des;
                ans+=1;
            }

        }
        return ans;





    }
}
