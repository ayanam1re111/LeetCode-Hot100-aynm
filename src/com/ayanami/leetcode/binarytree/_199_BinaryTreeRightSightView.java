package com.ayanami.leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;

public class _199_BinaryTreeRightSightView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans= new ArrayList<>();
        rightSight(root,1,ans);
        return ans;

    }
    private void rightSight(TreeNode root,int depth,List<Integer> ans){
        if (root==null){
            return;
        }
        //如果root第一次达到这个深度，存入ans
        if(depth==ans.size()+1){
            ans.add(root.val);

        }
        //先递归遍历右边到底
        rightSight(root.right,depth+1,ans);
        //右子树结束开始左边
        rightSight(root.left,depth+1,ans);

    }
}
