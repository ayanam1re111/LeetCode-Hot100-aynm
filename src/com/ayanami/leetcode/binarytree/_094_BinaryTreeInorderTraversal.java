package com.ayanami.leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;

public class _094_BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
      List<Integer> ans=new ArrayList<>();
         getNode(root,ans);
         return ans;}



     private void getNode(TreeNode root,List<Integer> ans){
         if(root==null){
             return;//停止，回到上一层
         }

         getNode(root.left,ans);
         ans.add(root.val);//将节点数值传入数组
         getNode(root.right,ans);

     }}

