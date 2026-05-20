package com.ayanami.leetcode.binarytree;

import java.util.HashMap;
import java.util.Map;

public class _105_ConstructBinaryTreeFromPreorderAndInorderTraversal {
    Map<Integer,Integer> map=new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //将中序遍历的数组存进map，方便定位切割
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return cutTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    public TreeNode cutTree(int[] preorder,int prestart,int preend,int[] inorder,int instart,int inend){

        if(prestart>preend||instart>inend){
            return null;
        }
        //判断数组是否还有,遵循闭区间
        if(prestart>preend||instart>inend){
            return null;
        }
        //拿到root
        int c=preorder[prestart];
        int idx=map.get(c);//拿到root在中序遍历中的索引
        TreeNode root=new TreeNode(c);
        int leftlen=idx-instart;//计算左子树节点个数
        //左子树：前序：prestart+1~prestart+leftlen;中序：instart~instart+leftlen-1
        root.left=cutTree(preorder,prestart+1,prestart+leftlen,inorder,instart,instart+leftlen-1);

        //右子树：前序：prestart+leftlen+1~preend;中序：instart+leftlen+1~inend
        root.right=cutTree(preorder,prestart+leftlen+1,preend,inorder,instart+leftlen+1,inend);
        return root;
    }
}
