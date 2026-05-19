package com.ayanami.leetcode.binarytree;
import java.util.Deque;
import java.util.ArrayDeque;

public class _230_KthSmallestElementsInaBST {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack=new ArrayDeque<TreeNode>();
        //如果没有 root != null，只要根节点的右子树有 2 个及以上节点，程序会提前退出循环，遍历不完
        while(root!=null ||!stack.isEmpty()){//stack不为空的放行条件是为了让root.right为null的情况下继续进行循环
            //先走到左子树的尽头
            while(root!=null){
                stack.push(root);//压栈
                root=root.left;
            }
            //弹栈（后进先出，小的先出）
            root=stack.pop();
            --k;
            if(k==0){
                break;
            }
            //在处理该节点的右子树（右子树一定大于该节点但小于上一个左子树节点）
            root=root.right;
        }
        return root.val;

    }
}
