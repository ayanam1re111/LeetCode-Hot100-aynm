package com.ayanami.leetcode.binarytree;

public class _114_FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        while(root!=null){
            //如果左节点没有，直接进入下一个节点
            if(root.left==null){
                root=root.right;
            }else{
                TreeNode pre=root.left;
                //走到左子树的最右节点a
                while(pre.right!=null){
                    pre=pre.right;
                }
                //将右子树拼接到a(pre的右指针指向root.right)
                pre.right=root.right;
                //root右指针指向root.left
                root.right=root.left;
                //此时左右指针指向同一个节点，需要清空左指针
                root.left=null;
                //考虑下一个节点
                root=root.right;

            }
        }
    }
}
