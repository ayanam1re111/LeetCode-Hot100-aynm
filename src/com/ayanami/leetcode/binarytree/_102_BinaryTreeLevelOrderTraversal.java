package com.ayanami.leetcode.binarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class _102_BinaryTreeLevelOrderTraversal {
    private List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        //队列，先进先出
        Queue<TreeNode> queue=new ArrayDeque<>();
        if(root!=null){
            queue.add(root);
        }
        while(!queue.isEmpty()){
            int size=queue.size();//记录这一层一共几个节点
            //用于记录该轮的节点
            List<Integer> level=new ArrayList<>();
            //循环中：1.将上一轮存的节点全部取出，加入level数组,出循环将该层级加入ans 2.存入下一层级的节点
            for (int i=0;i<size;i++){
                TreeNode node=queue.poll();
                level.add(node.val);
                //将左右节点加入队列中
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }

            }
            //将该轮节点数组加入ans
            ans.add(level);


        }
        return ans;

    }
}
